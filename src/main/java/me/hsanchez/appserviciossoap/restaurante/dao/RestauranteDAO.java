/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.restaurante.dao;

import com.itorizaba.serviciosrestaurante.Restaurante;
import java.sql.SQLException;
import java.util.List;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import me.hsanchez.appserviciossoap.restaurante.dao.queries.RestauranteQueries;
import me.hsanchez.appserviciossoap.restaurante.datasource.RestauranteDatasource;
import me.hsanchez.appserviciossoap.restaurante.handler.RestauranteBeanHandler;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class RestauranteDAO {
    public List<Restaurante> obtenerRestaurantesPorCiudad(String ciudad) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(RestauranteDatasource.getDatasource());
        
        RestauranteBeanHandler rsh = new RestauranteBeanHandler(qr);
        
        try {
            List<Restaurante> results = qr.query(RestauranteQueries.OBTENER_POR_CIUDAD, rsh, "%"+ciudad+"%");
            
            return results;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Ocurrió un error obteniendo los restaurantes", ex);
        }
    }
}
