/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.tienda.handler;

import com.itorizaba.serviciostienda.ProductoSugerido;
import com.itorizaba.serviciostienda.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import me.hsanchez.appserviciossoap.tienda.dao.queries.ProductoQueries;
import me.hsanchez.appserviciossoap.tienda.dao.queries.ProveedorQueries;
import me.hsanchez.appserviciossoap.tienda.dto.ProductoDTO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class ListaProductoBeanHandler extends BeanListHandler<ProductoDTO>{

    private final QueryRunner qr;
    
    public ListaProductoBeanHandler(QueryRunner qr) {
        super(ProductoDTO.class);
        
        this.qr = qr;
    }

    @Override
    public List<ProductoDTO> handle(ResultSet rs) throws SQLException {
        List<ProductoDTO> productos = super.handle(rs);
        
        BeanHandler<Proveedor> pbh = new BeanHandler<>(Proveedor.class);
        BeanListHandler<ProductoSugerido> sblh = new BeanListHandler<>(ProductoSugerido.class);
        
        for (ProductoDTO producto : productos) {
            Proveedor proveedor = qr.query(ProveedorQueries.OBTENER_POR_ID, pbh, producto.getProveedorId());
            producto.setProveedor(proveedor);
            
            List<ProductoSugerido> sugeridos = qr.query(ProductoQueries.OBTENER_PRODUCTOS_SUGERIDOS, sblh, producto.getId());
            producto.getLista().addAll(sugeridos);
        }
        
        return productos;
    }
    
}
