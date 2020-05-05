/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.appserviciossoap.estudiantes.dto;

import com.itorizaba.servicioestudiantes.Alumno;
import com.itorizaba.servicioestudiantes.ListaAlumno;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Modelo de Estudiante
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class AlumnoDTO {
    private int id;
    private String numControl;
    private String nombre;
    private String carrera;
    private double promedio;
    private int semestre;
    private String direccion;
    private int edad;
    private String telefono;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Alumno toAlumno() {
        Alumno a = new Alumno();
        
        a.setCarrera(this.getCarrera());
        a.setDireccion(this.getDireccion());
        a.setEdad(this.getEdad());
        a.setEmail(this.getEmail());
        a.setNombre(this.getNombre());
        a.setNumControl(this.getNumControl());
        a.setPromedio(this.getPromedio());
        a.setSemestre(this.getSemestre());
        a.setTelefono(this.getTelefono());
        
        return a;
    }
    
    public static ListaAlumno convertList(List<AlumnoDTO> lista) {
        List<Alumno> alumnos = lista.stream().map(a -> {
            return a.toAlumno();
        }).collect(Collectors.toList());
        
        ListaAlumno listaAlumno = new ListaAlumno();
        listaAlumno.getItem().addAll(alumnos);
        
        return listaAlumno;
    }
}
