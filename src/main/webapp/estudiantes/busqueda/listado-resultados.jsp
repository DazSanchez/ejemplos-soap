<%-- 
    Document   : listado-resultados
    Created on : 4/05/2020, 07:11:37 PM
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

            <t:busqueda exito="${exito}" error="${error}" q="${q}" placeholder="Ej: ${ejemplo}" claseBoton="primary" textoBoton="Buscar" metodo="GET">
                <section class="py-2">
                    <p class="h5 pb-2">Alumnos encontrados para "${q}"</p>
                    <t:listado_alumnos items="${alumnos}" length="${total}" />
                </section>
            </t:busqueda>
        </div>
    </div>
</t:layout>