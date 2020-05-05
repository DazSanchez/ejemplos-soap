<%-- 
    Document   : index
    Created on : 2/05/2020, 06:18:13 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Estudiantes - Menú">
    <div class="card shadow-sm">
        <div class="card-body">

            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h2">Servicios SOAP (Estudiantes)</p>

                <a href='<c:url value="/" />'>Volver al menú</a>
            </div>

            <ul class="list-group py-2">
                <a href='<c:url value="/estudiantes/verificar-inscrito" />' class="list-group-item list-group-item-action text-primary">
                    Ver si un alumno está inscrito
                </a>
                <a href='<c:url value="/estudiantes/busqueda/num-control" />' class="list-group-item list-group-item-action text-primary">
                    Buscar un alumno por número de control
                </a>
                <a href='<c:url value="/estudiantes/inscritos" />' class="list-group-item list-group-item-action text-primary">
                    Ver todos los alumnos inscritos
                </a>
                <a href='<c:url value="/estudiantes/busqueda/carrera" />' class="list-group-item list-group-item-action text-primary">
                    Ver alumnos inscritos por carrera
                </a>
                <a href='<c:url value="/estudiantes/baja" />' class="list-group-item list-group-item-action text-primary">
                    Dar de baja un alumno
                </a>
                <a href='<c:url value="/estudiantes/busqueda/semestre" />' class="list-group-item list-group-item-action text-primary">
                    Ver alumnos inscritos por semestre
                </a>
                <a href='<c:url value="/estudiantes/busqueda/promedio" />' class="list-group-item list-group-item-action text-primary">
                    Ver alumnos inscritos por promedio
                </a>
                <a href='<c:url value="/estudiantes/busqueda/edad" />' class="list-group-item list-group-item-action text-primary">
                    Ver alumnos inscritos por rango de edad
                </a>
            </ul>
        </div>
    </div>
</t:layout>