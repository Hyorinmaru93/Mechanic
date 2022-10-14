<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../header.jsp"%>

<c:if test="${carList != null}">
    <div style="width: 900px; min-height: 50px; margin-bottom: 10px; text-align: center">
    <span style="font-size: 36px">Your cars:</span>
    </div>
    <c:forEach items="${carList}" var="car" varStatus="loop">
    <div style="width: 900px; min-height: 180px; margin-bottom: 10px">
        <div style="width: 240px; height: 180px; float: left">
            <img src="/static/images/logos/${car.brand}.png">
        </div>
        <div style="float:left; width: 660px">
            <div>
            <input style="font-size: 20px" type="text" value="${car.customName}">
            <button class="custom_name_change">Change Name</button>
            <br/>
            Car brand: ${car.brand}
            <br/>
            Car model: ${car.model}
            <br/>
            Car production year: ${car.productionDate}
            </div>
        </div>
        <div styl="clear:both;"></div>
    </div>
    </c:forEach>
</c:if>
<%@include file="../footer.jsp"%>
