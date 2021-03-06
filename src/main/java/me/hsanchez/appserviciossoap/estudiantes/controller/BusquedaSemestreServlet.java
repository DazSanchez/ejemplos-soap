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

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebServlet(name = "BusquedaSemestreServlet", urlPatterns = {"/estudiantes/busqueda/semestre"})
public class BusquedaSemestreServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/ServicioEstudiantes.wsdl")
    private ServicioEstudiantes service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");

        req.setAttribute("termino", "semestre");
        req.setAttribute("ejemplo", "7");

        if (q != null) {
            try {
                ServicioEstudiantesPortType port = service.getServicioEstudiantesPort();
                Holder<ListaAlumno> alumnos = new Holder<>();
                Holder<ErrorPeticion> error = new Holder<>();
                port.alumnosInscritosPorSemestre(Integer.parseInt(q), alumnos, error);

                if (error.value.isHayError()) {
                    Exception e = new Exception(error.value.getMensaje());
                    req.setAttribute("error", e);
                } else {
                    List<Alumno> lista = alumnos.value.getItem();

                    req.setAttribute("alumnos", lista);
                    req.setAttribute("total", lista.size());
                    req.setAttribute("exito", true);
                }
            } catch (NumberFormatException ex) {
                ErrorPeticion ep = new ErrorPeticion();
                ep.setMensaje("El semestre debe ser un número");
                req.setAttribute("error", ep);
            }
        }

        req.setAttribute("q", q);

        this.renderPage(req, resp);
    }

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/estudiantes/busqueda/listado-resultados.jsp").forward(request, response);
    }
}
