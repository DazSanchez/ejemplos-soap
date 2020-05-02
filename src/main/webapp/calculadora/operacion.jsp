<%-- 
    Document   : operacion
    Created on : 2/05/2020, 05:24:49 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Calculadora">
    <div class="card shadow-sm">
        <div class="card-body">
            <p class="h3">Calcular</p>

            <c:if test="${error != null}">
                <div class="alert alert-danger">
                    ${error}
                </div>
            </c:if>

            <form method="POST" class="form-inline">
                <input type="number" name="a" class="form-control mr-2" value="${a}" required="required" />
                
                <select class="form-control mr-2" name="op">
                    <option ${op == '1' ? 'selected' :'' } value="1">+</option>
                    <option ${op == '2' ? 'selected' :'' } value="2">-</option>
                    <option ${op == '3' ? 'selected' :'' } value="3">x</option>
                    <option ${op == '4' ? 'selected' :'' } value="4">/</option>
                </select>

                <input type="number" name="b" class="form-control mr-2" value="${b}" required="required" />

                <span class="d-block mr-2 font-weight-bold">=</span>

                <input type="number" readonly="readonly" class="form-control mr-2" placeholder="Resultado" value="${result}"/>

                <button type="submit" class="btn btn-primary">Calcular</button>
            </form>
        </div>
    </div>
</t:layout>