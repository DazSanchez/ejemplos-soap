/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.wsdl.calculadora;

import javax.jws.WebService;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebService(serviceName = "ServicioCalculadora", portName = "ServicioCalculadoraPort", endpointInterface = "com.itorizaba.serviciocalculadora.ServicioCalculadoraPortType", targetNamespace = "http://www.itorizaba.com/ServicioCalculadora.wsdl", wsdlLocation = "WEB-INF/wsdl/ServicioCalculadora.wsdl")
public class ServicioCalculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        return a / b;
    }
    
}
