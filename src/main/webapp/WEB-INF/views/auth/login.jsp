<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
LOGIN

<form id="login_form" action="/auth/doLogin.do" method="post">
    <input id="name" name="name"/>
    <input id="password" name="password"/>
    <button type="submit" value="提交">提交</button>
</form>
</body>
</html>
