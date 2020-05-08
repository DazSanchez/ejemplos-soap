/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.tienda.service;

import com.itorizaba.serviciostienda.ListaProductos;
import com.itorizaba.serviciostienda.Producto;
import java.util.List;
import java.util.stream.Collectors;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import me.hsanchez.appserviciossoap.tienda.dao.ProductoDAO;
import me.hsanchez.appserviciossoap.tienda.dto.ProductoDTO;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class ProductoService {
    private final ProductoDAO productoDAO;

    public ProductoService() {
        this.productoDAO = new ProductoDAO();
    }
    
    public ListaProductos obtenerProductos() throws QueryExecutionException {
        List<ProductoDTO> resultados = this.productoDAO.obtenerProductos();
        
        List<Producto> productos = resultados.stream().map(p -> p.getProducto()).collect(Collectors.toList());
        ListaProductos lista = new ListaProductos();
        
        lista.getItem().addAll(productos);
        
        return lista;
    }
}
