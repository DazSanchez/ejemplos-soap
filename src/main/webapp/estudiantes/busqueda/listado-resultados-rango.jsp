<%-- 
    Document   : listado-resultado-rango
    Created on : 5/05/2020, 01:50:14 AM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Estudiantes - Búsqueda por ${termino}">
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h4">Buscar por ${termino}</p>

                <a href='<c:url value="/estudiantes" />'>Volver al menú</a>
            </div>

            <t:busqueda_rango exito="${exito}" error="${error}" min="${min}" max="${max}">
                <section class="py-2">
                    <p class="h5 pb-2">Resultado de búsqueda</p>
                    <t:listado_alumnos items="${alumnos}" length="${total}" />
                </section>
            </t:busqueda_rango>
        </div>
    </div>
</t:layout>