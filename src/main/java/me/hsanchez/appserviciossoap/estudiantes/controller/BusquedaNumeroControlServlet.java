package me.hsanchez.appserviciossoap.estudiantes.controller;

import com.itorizaba.servicioestudiantes.Alumno;
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
@WebServlet(name = "BusquedaNumeroControlServlet", urlPatterns = {"/estudiantes/busqueda/num-control"})
public class BusquedaNumeroControlServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AppServiciosSOAP/ServicioEstudiantes.wsdl")
    private ServicioEstudiantes service;

    private final EstudiantesService estudiantesService;

    public BusquedaNumeroControlServlet() {
        super();
        this.estudiantesService = new EstudiantesService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");

        if (q != null) {
            ServicioEstudiantesPortType port = service.getServicioEstudiantesPort();

            Holder<Alumno> alumno = new Holder<>();
            Holder<ErrorPeticion> error = new Holder<>();

            port.obtenerDetalles(q, alumno, error);

            if (error.value.isHayError()) {
                req.setAttribute("error", error.value);
            } else {
                req.setAttribute("alumno", alumno.value);
                req.setAttribute("exito", true);
            }
        }

        req.setAttribute("q", q);

        this.renderPage(req, resp);
    }

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/estudiantes/busqueda/numero-control.jsp").forward(request, response);
    }

}
