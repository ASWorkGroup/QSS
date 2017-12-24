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
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12"><tiles:insertAttribute name="header" /></div>
    </div>
    <div class="row">
        <div class="col-lg-12"><tiles:insertAttribute name="menu" /></div>
    </div>
    <form id="form1" action="<%=request.getAttribute("form1_action")%>" method="post">
        <div class="row">
            <div class="col-lg-12"><tiles:insertAttribute name="toolbar" /></div>
        </div>
        <div class="row">
            <div class="col-lg-12"><tiles:insertAttribute name="body" /></div>
        </div>
    </form>
    <div class="row">
        <div class="col-lg-12"><tiles:insertAttribute name="uploader" /></div>
    </div>
    <div class="row">
        <div class="col-lg-12"><hr/></div>
    </div>
    <div class="row">
        <div class="col-lg-12"><tiles:insertAttribute name="footer" /></div>
    </div>
</div>
</body>
</html>
