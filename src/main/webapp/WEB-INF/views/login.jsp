<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp"%>
<div>
    Dont have an accoutn? You can create it <a href="<c:url value="/registry"/>">here</a>
</div>
<form:form method="post" modelAttribute="user">
    <div>
        <label id="name">Login:</label>
        <form:input path="username" id="name" />
        <form:errors path="username" cssClass="error"/>
    </div>
    <div>
        <label id="password">Password:</label>
        <form:password path="password" id="password" maxlength="20"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <c:if test="${param.error == true}">
        <div>
            <p style="color: red">Login or password are incorrect.</p>
        </div>
    </c:if>
    <div>
        <button type="submit">Sign in</button>
    </div>
</form:form>
<%@include file="footer.jsp"%>
