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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceRef;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import me.hsanchez.appserviciossoap.estudiantes.service.EstudiantesService;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebServlet(name = "DarBajaAlumnoServlet", urlPatterns = {"/estudiantes/baja"})
public class DarBajaAlumnoServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/ServicioEstudiantes.wsdl")
    private ServicioEstudiantes service;

    private final EstudiantesService estudiantesService;

    public DarBajaAlumnoServlet() {
        super();
        this.estudiantesService = new EstudiantesService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.renderPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");

        if (q != null) {
            ServicioEstudiantesPortType port = service.getServicioEstudiantesPort();

            Holder<Boolean> exito = new Holder<>();
            Holder<ErrorPeticion> error = new Holder<>();
            port.darBaja(q, exito, error);

            if (error.value.isHayError()) {
                req.setAttribute("error", error.value);
            } else if (!exito.value) {
                ErrorPeticion ep = new ErrorPeticion();
                ep.setMensaje("No se encontró un alumno con número de control: " + q);
                req.setAttribute("error", ep);
            } else {
                req.setAttribute("exito", exito.value);
            }
        }

        req.setAttribute("q", q);

        this.renderPage(req, resp);
    }

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/estudiantes/dar-baja.jsp").forward(request, response);
    }
}
