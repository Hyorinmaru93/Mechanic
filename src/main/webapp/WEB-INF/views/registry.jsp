<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp"%>
<div>
    Already have an account? Go to <a href="<c:url value="/login"/>">login page</a>
</div>
<form:form method="post" modelAttribute="user">
    <div>
        <label id="name">Login:</label>
        <form:input path="username" id="username"/>
        <form:errors path="username" element="div" cssClass="error"/>
    </div>
    <div>
        <label id="password">Password:</label>
        <form:password path="password" id="password"/>
        <form:errors path="password" element="div" cssClass="error"/>
    </div>
    <div>
        <button type="submit">Registry</button>
    </div>
</form:form>

<%@include file="footer.jsp"%>
