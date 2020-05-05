<%-- 
    Document   : dar-baja
    Created on : 4/05/2020, 07:44:33 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Estudiantes - Dar de baja">
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h4">Buscar por número de control</p>

                <a href='<c:url value="/estudiantes" />'>Volver al menú</a>
            </div>

            <t:busqueda exito="${exito}" error="${error}" q="${q}" placeholder="Ej: 12345678" claseBoton="danger" textoBoton="Dar de baja" metodo="POST">
                <div class="alert alert-success">
                    El alumno con número de control <strong>${q}</strong> fue dado de baja con éxito.
                </div>
            </t:busqueda>
        </div>
    </div>
</t:layout>