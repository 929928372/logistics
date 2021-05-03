<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>物流配货系统login</title>
    <%@include file="/pages/common/header.jsp" %>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="row background_msg">
        <div class="col-md-8 text_position">
            <form class="form-horizontal" onsubmit="return checkForm()" action="/logistics/clientServlet?action=login"
                  method="post">
                <div class="form-group" id="usernameID">
                    <label class="col-md-2 control-label">用户名</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="请输入用户名" id="username"
                               name="username" value="root">
                    </div>
                    <label class="col-md-2 control-label" id="usernameMsg"></label>
                </div>
                <div class="form-group" id="passwordID">
                    <label class="col-md-2 control-label">密码</label>
                    <div class="col-md-4">
                        <input type="password" class="form-control" placeholder="请输入密码" id="password"
                               name="password" value="root">
                    </div>
                    <label class="col-md-2 control-label" id="passwordMsg"></label>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label">身份</label>
                    <div class="col-md-4">
                        <select name="identity" class="form-control">
                            <option value="user" selected="">用户</option>
                            <option value="manager" selected="">管理员</option>
                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-offset-2 col-md-2">
                        <input class="btn btn-default" type="submit" value="登录">
                        <a href="pages/user/register.jsp">注册</a>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="row text-center row_position">
        <span>物流配货系统.Copyright &copy;2021</span>
    </div>
</div>
<script src="static/js/jquery-3.5.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
