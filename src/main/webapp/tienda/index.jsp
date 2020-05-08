<%-- 
    Document   : index
    Created on : 8/05/2020, 02:49:49 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Tienda - Menú">
    <div class="card shadow-sm">
        <div class="card-body">

            <div class="d-flex align-items-center justify-content-between pb-2">
                <p class="h2">Servicios SOAP (Tienda)</p>

                <a href='<c:url value="/" />'>Volver al menú</a>
            </div>

            <ul class="list-group py-2">
                <a href='<c:url value="/tienda/productos" />' class="list-group-item list-group-item-action text-primary">
                    Lista de productos
                </a>
            </ul>
        </div>
    </div>
</t:layout>