<%-- 
    Document   : listado-productos
    Created on : 8/05/2020, 02:51:14 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<t:layout title="Tienda - Productos">
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h4">Productos disponibles</p>

                <a href='<c:url value="/tienda" />'>Volver al menú</a>
            </div>

            <c:if test="${error != null}">
                <div class="alert alert-danger">
                    ${error.message}
                </div>
            </c:if>

            <c:if test="${resultados!= null}">
                <c:choose>
                    <c:when test="${empty resultados}">
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
                                        <th scope="col">Precio</th>
                                        <th scope="col">Proveedor</th>
                                        <th scope="col">Menú</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${resultados}" var="producto" varStatus="prodStatus">
                                        <tr>
                                            <td>${producto.nombre}</td>
                                            <td>${producto.descripcion}</td>
                                            <td>${producto.precio}</td>
                                            <td>${producto.proveedor.nombre}</td>
                                            <td>
                                                <c:if test="${!empty producto.lista}">
                                                    <button class="btn btn-link p-0" type="button" data-toggle="collapse" data-target="#prod-${prodStatus.index}" aria-expanded="false" aria-controls="collapseExample">
                                                        Ver sugerencias
                                                    </button>
                                                </c:if>
                                            </td>
                                        </tr>
                                        <tr class="collapse table-info" id="prod-${prodStatus.index}">
                                            <td colspan="5">
                                                <p class="h5">Productos sugeridos</p>
                                                <c:forEach items="${producto.lista}" var="sugerencia" varStatus="sugStatus">
                                                    <p class="mb-1">
                                                        <span class="h6">${sugerencia.nombre}</span>
                                                        <span class="text-muted">
                                                            (<fmt:formatNumber value="${sugerencia.precio}" type="currency"/>)
                                                        </span>: ${sugerencia.descripcion}
                                                    </p>

                                                    <c:if test="${!sugStatus.last}">
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
            </c:if>
        </div>
    </div>
</t:layout>