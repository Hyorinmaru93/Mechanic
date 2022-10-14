<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../header.jsp"%>
Brand: ${car.brand}
<br/>
Model ${car.model}
<br/>
Category: ${car.category}
<br/>
<form:form action="/user/car/add" modelAttribute="car" method="post">
    <form:hidden path="owner" value="${DBUser.id}"/>
    <form:hidden path="brand" value="${car.brand}"/>
    <form:hidden path="model" value="${car.model}"/>
    <form:hidden path="category" value="${car.category}"/>
    Select production date:
    <br/>
    <form:input path="productionDate" type="number" min="1950" value="2000" max="2022" />
    <br/>
    <input type="submit" value="Add"/>
</form:form>
<%@include file="../footer.jsp"%>
