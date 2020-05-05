<%-- 
    Document   : listado_alumnos
    Created on : 5/05/2020, 01:50:42 AM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@tag description="Listado de alumnos" pageEncoding="UTF-8"%>

<%@attribute name="length" required="true" %>
<%@attribute name="items" required="true" type="java.util.List" %>

<c:choose>
    <c:when test="${total > 0}">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">No. Control</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Carrea</th>
                        <th scope="col">Promedio</th>
                        <th scope="col">Semestre</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Edad</th>
                        <th scope="col">Teléfono</th>
                        <th scope="col">Email</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${items}" var="item">
                    <tr>
                        <td>${item.numControl}</td>
                        <td>${item.nombre}</td>
                        <td>${item.carrera}</td>
                        <td>${item.promedio}</td>
                        <td>${item.semestre}</td>
                        <td>${item.direccion}</td>
                        <td>${item.edad}</td>
                        <td>${item.telefono}</td>
                        <td>${item.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <div class="alert alert-info">
            No se han encontrado alumnos.
        </div>
    </c:otherwise>
</c:choose>