package me.hsanchez.appserviciossoap.estudiantes.service;

import com.itorizaba.servicioestudiantes.Alumno;
import com.itorizaba.servicioestudiantes.ListaAlumno;
import java.util.List;
import me.hsanchez.appserviciossoap.estudiantes.dao.EstudiantesDAO;
import me.hsanchez.appserviciossoap.estudiantes.dto.AlumnoDTO;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class EstudiantesService {

    private final EstudiantesDAO estudiantesDAO;

    public EstudiantesService() {
        this.estudiantesDAO = new EstudiantesDAO();
    }

    public boolean estaInscrito(String numeroControl) throws QueryExecutionException {
        AlumnoDTO alumno = this.estudiantesDAO.estaInscrito(numeroControl);

        return alumno != null;
    }

    public Alumno buscarPorNumeroControl(String numControl) throws QueryExecutionException {
        AlumnoDTO alumno = this.estudiantesDAO.buscarPorNumeroControl(numControl);
        
        return alumno != null ? alumno.toAlumno() : null;
    }

    public ListaAlumno obtenerAlumnosInscritos() throws QueryExecutionException {
        List<AlumnoDTO> alumnos = this.estudiantesDAO.obtenerAlumnosInscritos();
        
        return AlumnoDTO.convertList(alumnos);
    }

    public ListaAlumno buscarPorCarrera(String carrera) throws QueryExecutionException {
        List<AlumnoDTO> alumnos = this.estudiantesDAO.buscarPorCarrera(carrera);

        return AlumnoDTO.convertList(alumnos);
    }

    public boolean darBajaAlumno(String numeroControl) throws QueryExecutionException {
        boolean exito = this.estudiantesDAO.darBajaAlumno(numeroControl);

        return exito;
    }

    public ListaAlumno buscarPorSemestre(int semestre) throws QueryExecutionException {
        List<AlumnoDTO> alumnos = this.estudiantesDAO.buscarPorSemestre(semestre);

        return AlumnoDTO.convertList(alumnos);
    }

    public ListaAlumno buscarPorPromedio(double promedio) throws QueryExecutionException {
        List<AlumnoDTO> alumnos = this.estudiantesDAO.buscarPorPromedio(promedio);

        return AlumnoDTO.convertList(alumnos);
    }

    public ListaAlumno buscarPorRangoEdad(int min, int max) throws QueryExecutionException {
        List<AlumnoDTO> alumnos = this.estudiantesDAO.buscarPorRangoEdad(min, max);

        return AlumnoDTO.convertList(alumnos);
    }

}
