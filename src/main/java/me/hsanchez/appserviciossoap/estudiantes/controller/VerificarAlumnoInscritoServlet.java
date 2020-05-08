/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.estudiantes.controller;

import com.itorizaba.servicioestudiantes.ErrorPeticion;
import com.itorizaba.servicioestudiantes.ServicioEstudiantes;
import com.itorizaba.servicioestudiantes.ServicioEstudiantesPortType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceRef;
import me.hsanchez.appserviciossoap.estudiantes.service.EstudiantesService;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebServlet(name = "VerificarAlumnoInscritoServlet", urlPatterns = {"/estudiantes/verificar-inscrito"})
public class VerificarAlumnoInscritoServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AppServiciosSOAP/ServicioEstudiantes.wsdl")
    private ServicioEstudiantes service;

    private final EstudiantesService estudiantesService;

    public VerificarAlumnoInscritoServlet() {
        super();
        this.estudiantesService = new EstudiantesService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");

        if (q != null) {
            ServicioEstudiantesPortType port = service.getServicioEstudiantesPort();

            Holder<Boolean> estaInscrito = new Holder<>(false);
            Holder<ErrorPeticion> error = new Holder<>();

            port.estaInscrito(q, estaInscrito, error);

            if (error.value.isHayError()) {
                Exception e = new Exception(error.value.getMensaje());
                req.setAttribute("error", e);
            } else {
                req.setAttribute("estaInscrito", estaInscrito.value);
                req.setAttribute("exito", true);
            }
        }

        req.setAttribute("q", q);
        this.renderPage(req, resp);
    }

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/estudiantes/esta-inscrito.jsp").forward(request, response);
    }

}
