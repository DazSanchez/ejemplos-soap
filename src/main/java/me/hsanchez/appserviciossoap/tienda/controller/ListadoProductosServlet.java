/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.tienda.controller;

import com.itorizaba.serviciostienda.ErrorPeticion;
import com.itorizaba.serviciostienda.ListaProductos;
import com.itorizaba.serviciostienda.Producto;
import com.itorizaba.serviciostienda.ServiciosTienda;
import com.itorizaba.serviciostienda.ServiciosTiendaPortType;
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
@WebServlet(name = "ListadoProductosServlet", urlPatterns = {"/tienda/productos"})
public class ListadoProductosServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AppServiciosSOAP/ServiciosTienda.wsdl")
    private ServiciosTienda service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            ServiciosTiendaPortType port = service.getServiciosTiendaPort();
            Holder<ListaProductos> productos = new Holder<>();
            Holder<ErrorPeticion> error = new Holder<>();
            port.getProductos(productos, error);
            
            if(error.value.isFallo()) {
                throw new QueryExecutionException(error.value.getMensaje());
            }
            
            List<Producto> lista = productos.value.getItem();
            
            req.setAttribute("resultados", lista);
            req.setAttribute("exito", true);
        } catch (Exception ex) {
            req.setAttribute("error", ex);
        }
        
        req.getRequestDispatcher("/tienda/listado-productos.jsp").forward(req, resp);
    }
}
