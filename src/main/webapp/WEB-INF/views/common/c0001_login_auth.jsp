<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String actionUrl=request.getContextPath() + "/c0001/login.do";
    String url=request.getParameter("url");
    if (url!=null && !url.equals("null") && url.length()!=0){
        actionUrl += "?url=" + url;
    }
%>

<%--<form id="login_form" action="<%=actionUrl%>" method="post">--%>
    <div class="form-group col-lg-12">
        <label for="id"  class="col-lg-1 control-label">用户名</label>
        <div class="col-lg-2">
            <input type="text" class="form-control" id="id" name="id" placeholder="USER ID">
        </div>
        <%--<div class="col-lg-9">&nbsp;</div>--%>
    </div>
    <div class="form-group col-lg-12">
        <label for="password" class="col-lg-1 control-label">密码</label>
        <div class="col-lg-2">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <%--<div class="col-lg-9">&nbsp;</div>--%>
    </div>
    <div class="form-group col-lg-12">
        <div class="col-lg-12">
            <button class="btn btn-default" type="submit"><spring:message code="C0001.submit"/></button>
        </div>
    </div>
<%--</form>--%>