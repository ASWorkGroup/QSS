<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-responsive">
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <td><spring:message code="SYSUSER.id"/></td>
            <td><spring:message code="SYSUSER.Name"/></td>
            <td><spring:message code="SYSUSER.COMPANY"/></td>
            <td><spring:message code="SYSUSER.EMAIL"/></td>
            <td><spring:message code="SYSUSER.LANGUAGE"/></td>
            <td><spring:message code="SYSUSER.DEFAULTCOUNTRYREGION"/></td>
            <td><spring:message code="SYSUSER.PREFERREDTIMEZONE"/></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}" varStatus="userID">
            <tr>
                <td>${user.ID}</td>
                <td>${user.NAME}</td>
                <td>${user.COMPANY}</td>
                <td>${user.EMAIL}</td>
                <td>${user.LANGUAGE}</td>
                <td>${user.DEFAULTCOUNTRYREGION}</td>
                <td>${user.PREFERREDTIMEZONE}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>