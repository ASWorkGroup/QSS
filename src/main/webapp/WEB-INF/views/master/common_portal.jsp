<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/js/master.common.js"></script>

<div class="panel panel-primary">
    <form id="form1" name="form1">
        <div class="panel-heading">查询条件</div>
        <div id="searchCondition" class="panel-body">
            <div class="row">
                <div class="col-lg-10">&nbsp;</div>
                <div class="col-lg-2">
                    <button type="button" class="btn btn-default" onclick="doQuery()">查询</button>
                </div>
            </div>

        </div>
    </form>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">查询结果</div>
    <div id="searchList" class="panel-body">
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
    </div>
</div>
