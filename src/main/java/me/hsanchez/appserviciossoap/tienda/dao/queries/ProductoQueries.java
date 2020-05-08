/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.tienda.dao.queries;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class ProductoQueries {

    public static final String OBTENER_TODOS = "SELECT * FROM productos";
    public static final String OBTENER_PRODUCTOS_SUGERIDOS = "SELECT p.id, p.nombre, p.descripcion, p.precio FROM productos_sugeridos ps "
            + "INNER JOIN productos p ON ps.productoSugeridoId = p.id "
            + "WHERE ps.productoId = ?";
}
