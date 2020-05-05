<%-- 
    Document   : listado-inscritos
    Created on : 4/05/2020, 12:55:32 AM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Estudiantes - Inscritos">
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h4">Alumnos inscritos</p>

                <a href='<c:url value="/estudiantes" />'>Volver al menú</a>
            </div>

            <c:if test="${error != null}">
                <div class="alert alert-danger">
                    ${error.mensaje}
                </div>
            </c:if>

            <c:if test="${alumnos != null}">
                <t:listado_alumnos items="${alumnos}" length="${total}" />
            </c:if>
        </div>
    </div>
</t:layout>