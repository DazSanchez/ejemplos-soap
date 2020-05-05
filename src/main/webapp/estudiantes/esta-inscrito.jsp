<%-- 
    Document   : esta-inscrito
    Created on : 2/05/2020, 06:31:38 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Estudiantes - Verificar inscripción">
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h4">Buscar por número de control</p>

                <a href='<c:url value="/estudiantes" />'>Volver al menú</a>
            </div>

            <t:busqueda exito="${exito}" error="${error}" q="${q}" placeholder="Ej: 12345678" claseBoton="primary" textoBoton="Buscar" metodo="GET">
                <div class="alert alert-${estaInscrito ? 'success' : 'danger'}">
                    El alumno con número de control <strong>${q}</strong> ${estaInscrito ? '' : 'no'} está inscrito.
                </div>
            </t:busqueda>
        </div>
    </div>
</t:layout>