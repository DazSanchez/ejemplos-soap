<%-- 
    Document   : busqueda_rango
    Created on : 5/05/2020, 02:01:36 AM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@tag description="Formulario de busqueda con rango" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="exito" required="true" %>
<%@attribute name="error" required="true" type="com.itorizaba.servicioestudiantes.ErrorPeticion" %>
<%@attribute name="min" required="true" %>
<%@attribute name="max" required="true" %>

<form class="form-inline py-2" method="GET">
    <input class="form-control mr-2" type="text" required="required" name="min" placeholder="Min" value="${min}"/>
    
    <input class="form-control mr-2" type="text" required="required" name="max" placeholder="Max" value="${max}"/>

    <button class="btn btn-primary">Buscar</button>
</form>

<c:if test="${exito}">
    <jsp:doBody />
</c:if>

<c:if test="${error != null}">
    <div class="alert alert-danger">
        ${error.mensaje}
    </div>
</c:if>