<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
LOGIN
<form id="login_form" action="<%=request.getContextPath()%>/auth/doLogin.do?url=<%=request.getParameter("url")%>" method="post">
    <input id="id" name="id"/>
    <input id="password" name="password"/>
    <button type="submit" value="提交">提交</button>
</form>
</body>
</html>
