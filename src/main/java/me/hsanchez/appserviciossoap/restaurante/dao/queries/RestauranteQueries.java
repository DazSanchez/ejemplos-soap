/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.restaurante.dao.queries;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class RestauranteQueries {
    public static final String OBTENER_POR_CIUDAD = "SELECT * FROM restaurantes WHERE direccion LIKE ?";
}
