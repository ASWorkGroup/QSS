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
    </head>
    <body>
        <div class="container-fluid">
            <form id="login_form" action="<%=request.getContextPath()%>/c0001/login.do?url=<%=request.getParameter("url")%>" method="post">
                <div class="form-group">
                    <label for="id"  class="col-lg-1 control-label">用户名</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="id" name="id" placeholder="USER ID">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-lg-1 control-label">密码</label>
                    <div class="col-lg-2">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-2">
                        <button class="btn btn-default" type="submit"><spring:message code="C0001.submit"/></button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
