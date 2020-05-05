/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.estudiantes.controller;

import com.itorizaba.servicioestudiantes.Alumno;
import com.itorizaba.servicioestudiantes.ErrorPeticion;
import com.itorizaba.servicioestudiantes.ListaAlumno;
import com.itorizaba.servicioestudiantes.ServicioEstudiantes;
import com.itorizaba.servicioestudiantes.ServicioEstudiantesPortType;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "AlumnosInscritos", urlPatterns = {"/estudiantes/inscritos"})
public class AlumnosInscritosServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/ServicioEstudiantes.wsdl")
    private ServicioEstudiantes service;

    private final EstudiantesService estudiantesService;

    public AlumnosInscritosServlet() {
        super();
        this.estudiantesService = new EstudiantesService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServicioEstudiantesPortType port = service.getServicioEstudiantesPort();

        Holder<ListaAlumno> alumnos = new Holder<>();
        Holder<ErrorPeticion> error = new Holder<>();
        port.alumnosInscritos(alumnos, error);

        if (error.value.isHayError()) {
            req.setAttribute("error", error.value);
        } else {
            List<Alumno> lista = alumnos.value.getItem();

            req.setAttribute("alumnos", lista);
            req.setAttribute("total", lista.size());
            req.setAttribute("exito", true);
        }

        this.renderPage(req, resp);
    }

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/estudiantes/listado-inscritos.jsp").forward(request, response);
    }

}
