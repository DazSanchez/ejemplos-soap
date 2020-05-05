<%-- 
    Document   : numero-control
    Created on : 3/05/2020, 11:52:10 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Estudiantes - Búsqueda Número de Control">
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h4">Buscar por número de control</p>

                <a href='<c:url value="/estudiantes" />'>Volver al menú</a>
            </div>

                <t:busqueda exito="${exito}" error="${error}" q="${q}" placeholder="Ej: 12345678" claseBoton="primary" textoBoton="Buscar" metodo="GET">
                <section class="py-2">
                    <c:choose>
                        <c:when test="${alumno != null}">
                            <p class="h5 text-success">Alumno encontrado</p>
                            <p class="h6">${alumno.nombre}</p>
                            <p class="m-0">Número de control: ${alumno.numControl}</p>
                            <p class="m-0">Carrera: ${alumno.carrera}</p>
                            <p class="m-0">Promedio: ${alumno.promedio}</p>
                            <p class="m-0">Semestre: ${alumno.semestre}</p>
                            <p class="m-0">Dirección: ${alumno.direccion}</p>
                            <p class="m-0">Edad: ${alumno.edad}</p>
                            <p class="m-0">Teléfono: ${alumno.telefono}</p>
                            <p class="m-0">Email: ${alumno.email}</p>
                        </c:when>
                        <c:otherwise>
                            <p class="h5 text-danger">Alumno no encontrado</p>
                        </c:otherwise>
                    </c:choose>
                </section>
            </t:busqueda>
        </div>
    </div>
</t:layout>