<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1.0,user-scalable=no">
    <title>物流配货系统注册</title>
    <%@include file="/pages/common/header.jsp" %>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet"/>
    <script src="static/js/jquery-3.5.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/register.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row back thumbnail">
        <div class="col-xs-8 col-xs-offset-2 thumbnail"
             style="margin-top: 50px; margin-bottom: 50px;background-color: #fcfaec">
            <div class="row">
                <h3 class="col-xs-8 col-xs-offset-3" style="color: red;margin-bottom: 20px;">用户注册</h3>
            </div>
            <form class="form-horizontal" onsubmit="return checkForm()" action="clientServlet?action=register"
                  method="post" style="padding-left: 20%;">
                <div class="form-group">
                    <label class="col-md-2 control-label">用户名</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" placeholder="请输入用户名" id="username"
                               name="customer_user" onblur="checkUserName()">
                    </div>
                    <label class="col-md-2 control-label" id="usernameMsg"></label>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">密码</label>
                    <div class="col-md-6">
                        <input type="password" class="form-control" placeholder="请输入密码" id="password1"
                               name="password1" onblur="checkPassword()">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">确认密码</label>
                    <div class="col-md-6">
                        <input type="password" class="form-control" placeholder="再次输入密码" id="password2"
                               name="customer_password" onblur="checkPassword()">
                    </div>
                    <label class="col-md-2 control-label" id="passwordMsg"></label>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">电话号码</label>
                    <div class="col-md-6">
                        <input type="" class="form-control" placeholder="选填" name="customer_tel" id="tel">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">用户地址</label>
                    <div class="col-md-6">
                        <input type="" class="form-control" placeholder="请输入地址" name="customer_address" id="address">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">验证码</label>
                    <div class="col-md-3">
                        <input class="form-control" type="text" name="code" id="code"/>
                    </div>
                    <div class="col-md-3">
                        <img alt="验证码" id="code-img" src="captcha.jpg"
                             style="width: 141px; height: 33px;">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-2">
                        <input class="btn btn-default" type="button" id="ok" value="注册">
                    </div>
                    <label class="col-md-2 control-label" id="codeMsg" style="color: red"></label>
                </div>
                <script type="text/javascript">
                    $(function () {
                        $("#code-img").click(function () {
                            this.src = "captcha.jpg?time=" + new Date();
                        });
                        $('#code').blur(function () {
                            $('#codeMsg').html("");
                        });
                        $('#ok').click(function () {
                            if ($('#username').val() !== "" && $('#usernameMsg').val() === ""){
                                $.ajax({
                                    url: "clientServlet",
                                    data: {
                                        action: "register",
                                        customer_user: $('#username').val(),
                                        customer_password: $('#password2').val(),
                                        customer_tel: $('#tel').val(),
                                        customer_address: $('#address').val(),
                                        code: $('#code').val()
                                    },
                                    type: "POST",
                                    success: function (data) {
                                        if (data.msg === "codeError") {
                                            $('#codeMsg').html("验证码错误");
                                            $('#code-img').click();
                                        } else {
                                            location.href = data.msg;
                                        }
                                    },
                                    dataType: "json"
                                });
                            }else {
                                $('#codeMsg').html("表单无法提交");
                            }
                        });
                    });
                </script>
            </form>
        </div>
    </div>
    <div class="row text-center row_position">
        <span>物流配货系统.Copyright &copy;2021</span>
    </div>
</div>
</body>
</html>
