<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-responsive">
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <td><spring:message code="M0001.list.id"/></td>
            <td><spring:message code="M0001.list.Name"/></td>
            <td><spring:message code="M0001.list.COMPANY"/></td>
            <td><spring:message code="M0001.list.EMAIL"/></td>
            <td><spring:message code="M0001.list.LANGUAGE"/></td>
            <td><spring:message code="M0001.list.DEFAULTCOUNTRYREGION"/></td>
            <td><spring:message code="M0001.list.PREFERREDTIMEZONE"/></td>
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