/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.restaurante.controller;

import com.itorizaba.serviciosrestaurante.ListaRestaurante;
import com.itorizaba.serviciosrestaurante.ServiciosRestaurante;
import com.itorizaba.serviciosrestaurante.Error;
import com.itorizaba.serviciosrestaurante.Restaurante;
import com.itorizaba.serviciosrestaurante.ServiciosRestaurantePortType;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceRef;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebServlet(name = "BusquedaPorCiudadServlet", urlPatterns = {"/restaurantes/busqueda-ciudad"})
public class BusquedaPorCiudadServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AppServiciosSOAP/ServiciosRestaurante.wsdl")
    private ServiciosRestaurante service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        req.setAttribute("q", q);
        
        System.out.println("q: " + q);
        
        if(q != null) {
            try {
                ServiciosRestaurantePortType port = service.getServiciosRestaurantePort();
                Holder<ListaRestaurante> restaurantes = new Holder<>();
                Holder<Error> error = new Holder<>();
                port.getRestaurantes(q, restaurantes, error);
                
                if(error.value.isFallo()) {
                    throw new QueryExecutionException(error.value.getMensaje());
                }
                
                List<Restaurante> lista = restaurantes.value.getItem();
                
                req.setAttribute("resultados", lista);
                req.setAttribute("sinResultados", lista.isEmpty());
                req.setAttribute("exito", true);
            } catch (Exception ex) {
                req.setAttribute("error", ex);
            }
        }
        
        req.getRequestDispatcher("/restaurantes/busqueda-ciudad.jsp").forward(req, resp);
    }
    
}
