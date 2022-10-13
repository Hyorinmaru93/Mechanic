<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Mechanic Project</title>
  <link href="/static/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="container">
  <div id="logo">
    Mechanic Project
  </div>
  <div id="left-menu">
    <ul>
      <li><img src="/static/images/pngwing.com.png" height="150" width="150" style="margin-left: auto; margin-right: auto"/></li>
      <hr>
      <sec:authorize var="loggedIn" access="isAuthenticated()"/>
      <sec:authorize access="hasRole('ADMIN')">
        <li><a href="/admin/main">Admin page</a></li>
      </sec:authorize>
      <c:if test="${!loggedIn}">
        <li><a href="/login">Login</a></li>
        <li><a href="/registry">Registry</a></li>
      </c:if>
      <c:if test="${loggedIn}">
        <li><a href="/user/main">User page</a></li>
        <li><a href="/user/settings">My account</a></li>
        <li><a href="/logout">Logout </a></li>
      </c:if>
    </ul>
  </div>
  <div id="main">