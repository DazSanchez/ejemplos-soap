
package com.itorizaba.serviciocalculadora;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicioCalculadoraPortType", targetNamespace = "http://www.itorizaba.com/ServicioCalculadora.wsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ServicioCalculadoraPortType {


    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Sumar", action = "capeconnect:ServicioCalculadora:ServicioCalculadoraPortType#Sumar")
    @WebResult(name = "respuesta", partName = "respuesta")
    public int sumar(
        @WebParam(name = "a", partName = "a")
        int a,
        @WebParam(name = "b", partName = "b")
        int b);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Restar", action = "capeconnect:ServicioCalculadora:ServicioCalculadoraPortType#Restar")
    @WebResult(name = "respuesta", partName = "respuesta")
    public int restar(
        @WebParam(name = "a", partName = "a")
        int a,
        @WebParam(name = "b", partName = "b")
        int b);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Multiplicar", action = "capeconnect:ServicioCalculadora:ServicioCalculadoraPortType#Multiplicar")
    @WebResult(name = "respuesta", partName = "respuesta")
    public int multiplicar(
        @WebParam(name = "a", partName = "a")
        int a,
        @WebParam(name = "b", partName = "b")
        int b);

    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns double
     */
    @WebMethod(operationName = "Dividir", action = "capeconnect:ServicioCalculadora:ServicioCalculadoraPortType#Dividir")
    @WebResult(name = "respuesta", partName = "respuesta")
    public double dividir(
        @WebParam(name = "a", partName = "a")
        double a,
        @WebParam(name = "b", partName = "b")
        double b);

}