<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../header.jsp"%>
<form:form action="/user/car/model" modelAttribute="car" method="post">
  <form:hidden path="owner" value="${DBUser.id}"/>
  Select brand:
  <br/>
  <form:select path="brand">
    <form:options items="${brands}"/>
  </form:select>
  <br/>
  <input type="submit" value="Next"/>
</form:form>
<%@include file="../footer.jsp"%>
