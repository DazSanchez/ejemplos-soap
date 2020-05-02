/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.calculadora.controller;

import com.itorizaba.serviciocalculadora.ServicioCalculadora;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import com.itorizaba.serviciocalculadora.ServicioCalculadoraPortType;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebServlet(name = "OperacionCalculadoraServlet", urlPatterns = {"/calculadora"})
public class OperacionCalculadoraServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AppServiciosSOAP/ServicioCalculadora.wsdl")
    private ServicioCalculadora service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("op", "1");
        req.setAttribute("a", 1);
        req.setAttribute("b", 1);
        req.setAttribute("result", 2);
        this.renderPageForm(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String op = req.getParameter("op");

        try {
            ServicioCalculadoraPortType port = service.getServicioCalculadoraPort();
            Number result = 0;
            
            switch(op) {
                case "1":
                    result = port.sumar(Integer.parseInt(a, 10), Integer.parseInt(b, 10));
                    break;
                case "2":
                    result = port.restar(Integer.parseInt(a, 10), Integer.parseInt(b, 10));
                    break;
                case "3":
                    result = port.multiplicar(Integer.parseInt(a, 10), Integer.parseInt(b, 10));
                    break;
                case "4":
                    result = port.dividir(Double.parseDouble(a), Double.parseDouble(b));
                    break;
                default:
                    req.setAttribute("error", "Operación inválida");
            }
            
            req.setAttribute("result", result);
        } catch (Exception ex) {
            req.setAttribute("erorr", "Ha ocurrido un erorr");
        }

        req.setAttribute("a", a);
        req.setAttribute("b", b);
        req.setAttribute("op", op);

        this.renderPageForm(req, resp);
    }

    private void renderPageForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/calculadora/operacion.jsp").forward(request, response);
    }
}
