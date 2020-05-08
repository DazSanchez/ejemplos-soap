<%-- 
    Document   : busqueda
    Created on : 3/05/2020, 11:22:14 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@tag description="Formulario de busqueda" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="exito" required="true" %>
<%@attribute name="error" required="true" type="java.lang.Exception" %>
<%@attribute name="placeholder" required="true" %>
<%@attribute name="q" required="true" %>
<%@attribute name="textoBoton" required="true" %>
<%@attribute name="claseBoton" required="true" %>
<%@attribute name="metodo" required="true" %>

<form class="form-inline py-2" method="${metodo}">
    <input class="form-control mr-2" type="text" required="required" name="q" placeholder="${placeholder}" value="${q}"/>

    <button class="btn btn-${claseBoton}">${textoBoton}</button>
</form>

<c:if test="${exito}">
    <jsp:doBody />
</c:if>

<c:if test="${error != null}">
    <div class="alert alert-danger">
        ${error.message}
    </div>
</c:if>