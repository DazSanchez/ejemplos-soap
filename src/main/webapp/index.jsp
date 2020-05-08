<%-- 
    Document   : index
    Created on : 2/05/2020, 05:59:32 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Menú">
    <div class="card shadow-sm">
        <div class="card-body">
            <p class="h2">Servicios SOAP</p>

            <ul class="list-group pt-2">
                <a href='<c:url value="/calculadora" />' class="list-group-item list-group-item-action text-primary">
                    Calculadora
                </a>
                <a href='<c:url value="/estudiantes" />' class="list-group-item list-group-item-action text-primary">
                    Estudiantes
                </a>
                <a href='<c:url value="/restaurantes" />' class="list-group-item list-group-item-action text-primary">
                    Restaurantes
                </a>
                <a href='<c:url value="/tienda" />' class="list-group-item list-group-item-action text-primary">
                    Tienda
                </a>
            </ul>
        </div>
    </div>
</t:layout>