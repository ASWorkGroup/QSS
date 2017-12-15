<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <div class="container-fluid">
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
    </body>
</html>
