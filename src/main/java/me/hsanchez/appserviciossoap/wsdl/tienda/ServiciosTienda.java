/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.wsdl.tienda;

import com.itorizaba.serviciostienda.ErrorPeticion;
import com.itorizaba.serviciostienda.ListaProductos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import me.hsanchez.appserviciossoap.tienda.service.ProductoService;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebService(serviceName = "ServiciosTienda", portName = "ServiciosTiendaPort", endpointInterface = "com.itorizaba.serviciostienda.ServiciosTiendaPortType", targetNamespace = "http://www.itorizaba.com/ServiciosTienda.wsdl", wsdlLocation = "WEB-INF/wsdl/ServiciosTienda.wsdl")
public class ServiciosTienda {

    private final ProductoService productoService;

    public ServiciosTienda() {
        this.productoService = new ProductoService();
    }
    
    public void getProductos(Holder<ListaProductos> productos, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();
        ep.setFallo(false);
        
        try {
            ListaProductos resultados = this.productoService.obtenerProductos();
            productos.value = resultados;
        } catch (QueryExecutionException ex) {
            ep.setFallo(true);
            ep.setMensaje(ex.getMessage() + ": " + ex.getCause().getMessage());
            productos.value = new ListaProductos();
        }
        
        error.value = ep;
    }
    
}
