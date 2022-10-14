<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../header.jsp"%>
Brand: ${car.brand}
<br/>
<form:form action="/user/car/category" modelAttribute="car" method="post">
  Select model:
  <br/>
  <form:select path="model">
    <form:options items="${models}"/>
  </form:select>
  <br/>
  <input type="submit" value="Next"/>
</form:form>
<%@include file="../footer.jsp"%>
