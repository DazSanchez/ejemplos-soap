/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.wsdl.estudiantes;

import com.itorizaba.servicioestudiantes.Alumno;
import com.itorizaba.servicioestudiantes.ErrorPeticion;
import com.itorizaba.servicioestudiantes.ListaAlumno;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import me.hsanchez.appserviciossoap.estudiantes.service.EstudiantesService;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebService(serviceName = "ServicioEstudiantes", portName = "ServicioEstudiantesPort", endpointInterface = "com.itorizaba.servicioestudiantes.ServicioEstudiantesPortType", targetNamespace = "http://www.itorizaba.com/ServicioEstudiantes.wsdl", wsdlLocation = "WEB-INF/wsdl/ServicioEstudiantes.wsdl")
public class ServicioEstudiantesSOAP {

    private final EstudiantesService estudiantesService;

    public ServicioEstudiantesSOAP() {
        this.estudiantesService = new EstudiantesService();
    }

    public void estaInscrito(String numControl, Holder<Boolean> estaInscrito, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();
        estaInscrito.value = false;

        try {
            boolean resultado = this.estudiantesService.estaInscrito(numControl);
            estaInscrito.value = resultado;
            ep.setHayError(false);
        } catch (QueryExecutionException ex) {
            ep.setHayError(true);
            ep.setMensaje(ex.getMessage());
        }

        error.value = ep;
    }

    public void obtenerDetalles(String numControl, Holder<Alumno> alumno, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();
        try {
            Alumno resultado = this.estudiantesService.buscarPorNumeroControl(numControl);

            if (resultado != null) {
                alumno.value = resultado;
                ep.setHayError(false);
                return;
            }

            throw new QueryExecutionException("No se encontró un alumno con el número de control: " + numControl);
        } catch (QueryExecutionException ex) {
            alumno.value = new Alumno();
            ep.setHayError(true);
            ep.setMensaje(ex.getMessage());
        }

        error.value = ep;
    }

    public void alumnosInscritos(Holder<ListaAlumno> alumnos, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();

        try {
            ListaAlumno resultado = this.estudiantesService.obtenerAlumnosInscritos();
            alumnos.value = resultado;

            ep.setHayError(false);
        } catch (QueryExecutionException ex) {
            ep.setHayError(true);
            ep.setMensaje(ex.getMessage());
            alumnos.value = new ListaAlumno();
        }

        error.value = ep;
    }

    public void alumnosInscritosPorCarrera(String carrera, Holder<ListaAlumno> alumnos, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();

        try {
            ListaAlumno resultado = this.estudiantesService.buscarPorCarrera(carrera);
            alumnos.value = resultado;

            ep.setHayError(false);
        } catch (QueryExecutionException ex) {
            ep.setHayError(true);
            ep.setMensaje(ex.getMessage());
            alumnos.value = new ListaAlumno();
        }

        error.value = ep;
    }

    public void darBaja(String numControl, Holder<Boolean> exito, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();
        exito.value = false;

        try {
            boolean resultado = this.estudiantesService.darBajaAlumno(numControl);
            exito.value = resultado;

            ep.setHayError(false);
        } catch (QueryExecutionException ex) {
            ep.setHayError(true);
            ep.setMensaje(ex.getMessage());
        }

        error.value = ep;
    }

    public void alumnosInscritosPorSemestre(int semestre, Holder<ListaAlumno> alumnos, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();

        try {
            ListaAlumno resultado = this.estudiantesService.buscarPorSemestre(semestre);
            alumnos.value = resultado;

            ep.setHayError(false);
        } catch (QueryExecutionException ex) {
            ep.setHayError(true);
            ep.setMensaje(ex.getMessage());
            alumnos.value = new ListaAlumno();
        }

        error.value = ep;
    }

    public void alumnosInscritosPorPromedio(double promedio, Holder<ListaAlumno> alumnos, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();

        try {
            ListaAlumno resultado = this.estudiantesService.buscarPorPromedio(promedio);
            alumnos.value = resultado;

            ep.setHayError(false);
        } catch (QueryExecutionException ex) {
            ep.setHayError(true);
            ep.setMensaje(ex.getMessage());
            alumnos.value = new ListaAlumno();
        }

        error.value = ep;
    }

    public void alumnosInscritosPorRangoEdad(int min, int max, Holder<ListaAlumno> alumnos, Holder<ErrorPeticion> error) {
        ErrorPeticion ep = new ErrorPeticion();

        try {
            ListaAlumno resultado = this.estudiantesService.buscarPorRangoEdad(min, max);
            alumnos.value = resultado;

            ep.setHayError(false);
        } catch (QueryExecutionException ex) {
            ep.setHayError(true);
            ep.setMensaje(ex.getMessage());
            alumnos.value = new ListaAlumno();
        }

        error.value = ep;
    }

}
