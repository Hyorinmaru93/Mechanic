<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../header.jsp"%>
Brand: ${car.brand}
<br/>
Model ${car.model}
<br/>
<form:form action="/user/car/year" modelAttribute="car" method="post">
  <form:hidden path="owner" value="${DBUser.id}"/>
  <form:hidden path="brand" value="${car.brand}"/>
  <form:hidden path="model" value="${car.model}"/>
  Select category:
  <br/>
  <form:select path="category">
    <form:options items="${categories}"/>
  </form:select>
  <br/>
  <input type="submit" value="Next"/>
</form:form>
<%@include file="../footer.jsp"%>
