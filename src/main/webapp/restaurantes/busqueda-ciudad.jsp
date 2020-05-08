<%-- 
    Document   : busqueda-ciudad
    Created on : 7/05/2020, 09:19:55 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<t:layout title="Restaurantes - Por ciudad">
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h4">Buscar</p>

                <a href='<c:url value="/restaurantes" />'>Volver al menú</a>
            </div>

            <t:busqueda exito="${exito}" error="${error}" q="${q}" placeholder="Ej: Córdoba" claseBoton="primary" textoBoton="Buscar" metodo="GET">
                <c:choose>
                    <c:when test="${sinResultados}">
                        <div class="alert alert-info">
                            No se encontraron resultados
                        </div>
                    </c:when>
                    <c:otherwise>
                        <section class="py-2 table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Descripción</th>
                                        <th scope="col">Dirección</th>
                                        <th scope="col">Menú</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${resultados}" var="restaurante" varStatus="restStatus">
                                        <tr>
                                            <td>${restaurante.nombre}</td>
                                            <td>${restaurante.descripcion}</td>
                                            <td>${restaurante.direccion}</td>
                                            <td>
                                                <button class="btn btn-link p-0" type="button" data-toggle="collapse" data-target="#rest-${restStatus.index}" aria-expanded="false" aria-controls="collapseExample">
                                                    Ver menú
                                                </button>
                                            </td>
                                        </tr>
                                        <tr class="collapse table-info" id="rest-${restStatus.index}">
                                            <td colspan="5">
                                                <c:forEach items="${restaurante.menu.item}" var="menu" varStatus="status">
                                                    <p class="mb-1">
                                                        <span class="h6">${menu.platillo}</span>
                                                        <span class="text-muted">
                                                            (<fmt:formatNumber value="${menu.precio}" type="currency"/>)
                                                        </span>: ${menu.ingredientes}
                                                    </p>

                                                    <c:if test="${!status.last}">
                                                        <hr />
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </section>
                    </c:otherwise>
                </c:choose>
            </t:busqueda>
        </div>
    </div>
</t:layout>