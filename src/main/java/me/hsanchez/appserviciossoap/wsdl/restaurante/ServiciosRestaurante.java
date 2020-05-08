/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.wsdl.restaurante;

import com.itorizaba.serviciosrestaurante.ListaRestaurante;
import com.itorizaba.serviciosrestaurante.Error;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import me.hsanchez.appserviciossoap.restaurante.service.RestauranteService;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebService(serviceName = "ServiciosRestaurante", portName = "ServiciosRestaurantePort", endpointInterface = "com.itorizaba.serviciosrestaurante.ServiciosRestaurantePortType", targetNamespace = "http://www.itorizaba.com/ServiciosRestaurante.wsdl", wsdlLocation = "WEB-INF/wsdl/ServiciosRestaurante.wsdl")
public class ServiciosRestaurante {

    private final RestauranteService restauranteService;

    public ServiciosRestaurante() {
        this.restauranteService = new RestauranteService();
    }

    public void getRestaurantes(String ciudad, Holder<ListaRestaurante> restaurantes, Holder<Error> error) {
        Error e = new Error();
        e.setFallo(false);
        
        try {
            ListaRestaurante lista = this.restauranteService.obtenerRestaurantesPorCiudad(ciudad);
            restaurantes.value = lista;
        } catch (QueryExecutionException ex) {
            e.setFallo(true);
            e.setMensaje(ex.getMessage() + ": " + ex.getCause().getMessage());
            restaurantes.value = new ListaRestaurante();
        }
        
        error.value = e;
    }

}
