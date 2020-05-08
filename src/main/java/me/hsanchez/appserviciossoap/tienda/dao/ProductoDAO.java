/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.tienda.dao;

import java.sql.SQLException;
import java.util.List;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import me.hsanchez.appserviciossoap.tienda.dao.queries.ProductoQueries;
import me.hsanchez.appserviciossoap.tienda.datasource.TiendaDatasource;
import me.hsanchez.appserviciossoap.tienda.dto.ProductoDTO;
import me.hsanchez.appserviciossoap.tienda.handler.ListaProductoBeanHandler;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class ProductoDAO {
    public List<ProductoDTO> obtenerProductos() throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(TiendaDatasource.getDatasource());
        ListaProductoBeanHandler pbh = new ListaProductoBeanHandler(qr);
        
        try {
            List<ProductoDTO> lista = qr.query(ProductoQueries.OBTENER_TODOS, pbh);
            
            return lista;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Ocurrió un error obteniendo los productos", ex);
        }
    }
}
