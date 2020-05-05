package me.hsanchez.appserviciossoap.estudiantes.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.hsanchez.appserviciossoap.estudiantes.dao.queries.EstudiantesQueries;
import me.hsanchez.appserviciossoap.estudiantes.datasource.EstudiantesDataSource;
import me.hsanchez.appserviciossoap.estudiantes.dto.AlumnoDTO;
import me.hsanchez.appserviciossoap.estudiantes.exceptions.QueryExecutionException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class EstudiantesDAO {

    public AlumnoDTO estaInscrito(String numeroControl) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(EstudiantesDataSource.getDatasource());

        BeanHandler<AlumnoDTO> rsh = new BeanHandler<>(AlumnoDTO.class);

        try {
            AlumnoDTO alumno = qr.query(EstudiantesQueries.BUSCAR_POR_NUMERO_CONTROL, rsh, numeroControl);

            return alumno;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Error realizando la consulta", ex);
        }
    }

    public AlumnoDTO buscarPorNumeroControl(String numeroControl) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(EstudiantesDataSource.getDatasource());

        BeanHandler<AlumnoDTO> rsh = new BeanHandler<>(AlumnoDTO.class);

        try {
            AlumnoDTO alumno = qr.query(EstudiantesQueries.BUSCAR_POR_NUMERO_CONTROL, rsh, numeroControl);

            return alumno;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Error realizando la consulta", ex);
        }
    }

    public List<AlumnoDTO> obtenerAlumnosInscritos() throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(EstudiantesDataSource.getDatasource());

        BeanListHandler<AlumnoDTO> rsh = new BeanListHandler<>(AlumnoDTO.class);

        try {
            List<AlumnoDTO> alumnos = qr.query(EstudiantesQueries.OBTENER_TODOS, rsh);

            return alumnos;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Error realizando la consulta", ex);
        }
    }

    public List<AlumnoDTO> buscarPorCarrera(String carrera) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(EstudiantesDataSource.getDatasource());

        BeanListHandler<AlumnoDTO> rsh = new BeanListHandler<>(AlumnoDTO.class);

        try {
            List<AlumnoDTO> alumnos = qr.query(EstudiantesQueries.BUSCAR_POR_CARRERA, rsh, carrera);

            return alumnos;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Error realizando la consulta", ex);
        }
    }

    public boolean darBajaAlumno(String numeroControl) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(EstudiantesDataSource.getDatasource());

        try {
            int update = qr.update(EstudiantesQueries.DAR_BAJA_POR_NUMERO_CONTROL, numeroControl);

            return update > 0;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Error dando de baja al alumno", ex);
        }
    }
    
    public List<AlumnoDTO> buscarPorSemestre(int semestre) throws QueryExecutionException {
        QueryRunner qr =new QueryRunner(EstudiantesDataSource.getDatasource());
        
        BeanListHandler<AlumnoDTO> rsh = new BeanListHandler<>(AlumnoDTO.class);
        
        try {
            List<AlumnoDTO> alumnos = qr.query(EstudiantesQueries.BUSCAR_POR_SEMESTRE, rsh, semestre);
            
            return alumnos;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Error realizando la consulta", ex);
        }
    }
    
    public List<AlumnoDTO> buscarPorPromedio(double promedio) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(EstudiantesDataSource.getDatasource());
        
        BeanListHandler<AlumnoDTO> rsh = new BeanListHandler<>(AlumnoDTO.class);
        
        try {
            List<AlumnoDTO> alumnos = qr.query(EstudiantesQueries.BUSCAR_POR_PROMEDIO, rsh, promedio);
            
            return alumnos;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Error realizando la consulta", ex);
        }
    }
    
    public List<AlumnoDTO> buscarPorRangoEdad(int min, int max) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(EstudiantesDataSource.getDatasource());
        
        BeanListHandler<AlumnoDTO> rsh = new BeanListHandler<>(AlumnoDTO.class);
        
        try {
            List<AlumnoDTO> alumnos = qr.query(EstudiantesQueries.BUSCAR_POR_RANGO_EDAD, rsh, min, max);
            
            return alumnos;
        } catch (SQLException ex) {
            throw new QueryExecutionException("Error realizando la consulta", ex);
        }
    }

}
