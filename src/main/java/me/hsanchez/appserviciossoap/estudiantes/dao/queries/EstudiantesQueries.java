/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.estudiantes.dao.queries;

/**
 * Consultas de SQL para el servicio de Estudiantes
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class EstudiantesQueries {

    public static final String BUSCAR_POR_NUMERO_CONTROL = "SELECT * FROM alumnos WHERE numControl = ?";
    public static final String OBTENER_TODOS = "SELECT * FROM alumnos";
    public static final String BUSCAR_POR_CARRERA = "SELECT * FROM alumnos WHERE carrera = ?";
    public static final String DAR_BAJA_POR_NUMERO_CONTROL = "DELETE FROM alumnos WHERE numControl = ?";
    public static final String BUSCAR_POR_SEMESTRE = "SELECT * FROM alumnos WHERE semestre = ?";
    public static final String BUSCAR_POR_PROMEDIO = "SELECT * FROM alumnos WHERE promedio = ?";
    public static final String BUSCAR_POR_RANGO_EDAD = "SELECT * FROM alumnos WHERE edad >= ? AND edad <= ?";
}
