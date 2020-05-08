/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.restaurante.handler;

import com.itorizaba.serviciosrestaurante.ListaMenu;
import com.itorizaba.serviciosrestaurante.Menu;
import com.itorizaba.serviciosrestaurante.Restaurante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import me.hsanchez.appserviciossoap.restaurante.dao.queries.MenuQueries;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class RestauranteBeanHandler extends BeanListHandler<Restaurante> {
    
    private final QueryRunner qr;
    
    public RestauranteBeanHandler(QueryRunner qr) {
        super(Restaurante.class);
        this.qr = qr;
    }

    @Override
    public List<Restaurante> handle(ResultSet rs) throws SQLException {
        List<Restaurante> restaurantes = super.handle(rs);
        
        BeanListHandler<Menu> rsh = new BeanListHandler<>(Menu.class);
        
        for (Restaurante restaurante : restaurantes) {
            ListaMenu lista = new ListaMenu();
            
            List<Menu> menus = qr.query(MenuQueries.OBTENER_POR_ID_RESTAURANTE, rsh, restaurante.getId());
            lista.getItem().addAll(menus);
            
            restaurante.setMenu(lista);
        }
        
        return restaurantes;
    }
    
}
