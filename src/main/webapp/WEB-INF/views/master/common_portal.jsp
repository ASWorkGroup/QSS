<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/js/master.common.js"></script>

<div class="panel panel-primary">
    <div class="panel-heading">查询条件</div>
    <form id="form1" name="form1" class="form-inline">
        <div id="searchCondition" class="panel-body">
            <div class="row">
                <div class="col-lg-10">&nbsp;</div>
                <div class="col-lg-2">
                    <button type="button" class="btn btn-primary" onclick="doQuery()">查询</button>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">查询结果</div>
    <div id="searchList" class="panel-body">
        <div class="table-responsive">

        </div>
    </div>
</div>
