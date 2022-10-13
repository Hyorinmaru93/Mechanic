<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../header.jsp"%>

<form:form modelAttribute="userData" method="post">
    <form:hidden path="id" />
    First Name: <form:input path="firstName" />
    <form:errors path="firstName" />
    <br>
    Last Name: <form:input path="lastName" />
    <form:errors path="lastName" />
    <br>
    E-mail: <form:input path="email" />
    <form:errors path="email" element="div" cssClass="error"/>
    <br>
    Phone number: <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber" element="div" cssClass="error"/>
    <br>
    <input type="submit" value="Submit">
</form:form>

<%@include file="../footer.jsp"%>