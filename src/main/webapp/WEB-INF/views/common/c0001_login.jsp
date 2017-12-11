<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>login</title>
</head>
<body>
LOGIN
<spring:message code="C0001.submit"/>
<form id="login_form" action="<%=request.getContextPath()%>/c0001/login.do<%if (request.getParameter("url")==null) {%>?url=<%=request.getParameter("url")%><%}%>" method="post">
    <input id="id" name="id"/>
    <input id="password" name="password"/>
    <button type="submit" value="${C0001.submit}">提交</button>
</form>
</body>
</html>
