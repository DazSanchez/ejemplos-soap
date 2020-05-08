/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.tienda.dto;

import com.itorizaba.serviciostienda.Producto;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class ProductoDTO extends Producto {
    private int proveedorId;

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }
    
    public Producto getProducto() {
        return (Producto) this;
    }
}
