/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.restaurante.service;

import com.itorizaba.serviciosrestaurante.ListaRestaurante;
import com.itorizaba.serviciosrestaurante.Restaurante;
import java.util.List;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import me.hsanchez.appserviciossoap.restaurante.dao.RestauranteDAO;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class RestauranteService {

    private final RestauranteDAO restauranteDAO;
    
    public RestauranteService() {
        this.restauranteDAO = new RestauranteDAO();
    }
    
    public ListaRestaurante obtenerRestaurantesPorCiudad(String ciudad) throws QueryExecutionException {
        List<Restaurante> result = this.restauranteDAO.obtenerRestaurantesPorCiudad(ciudad);
        
        ListaRestaurante lista = new ListaRestaurante();
        lista.getItem().addAll(result);
        
        return lista;
    }
    
}
