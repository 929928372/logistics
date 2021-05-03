<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>物流配货系统add_form</title>
    <%@include file="/pages/common/header.jsp" %>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet"/>
	<script src="static/js/jquery-3.5.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container-fluid">

    <div class="text-right dividing_line row_position">
        <span>欢迎<span class="name_font">${sessionScope.clientName}</span>使用本系统</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="pages/user/main.jsp">返回首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="javascript:void(0);">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="clientServlet?action=logout">退出系统</a>
    </div>

    <div class="row text-right dividing_line">
        <ul class="list-inline">
            <li>
                <a class="btn btn-default btn-lg" href="clientServlet?action=page">发货单查询</a>
            </li>
            <li>
                <a class="btn btn-default btn-lg" href="add_form.jsp">填写发货单</a>
            </li>
        </ul>
    </div>


    <div class="row dividing_line font_style sp1">
        首页 >> 填写发货单
    </div>

    <div class="border_gray">
        <form action="clientServlet?action=addGood" method="post" class="form-horizontal">
            <!--第一行-->
            <div class="row">
                <label class="col-xs-2 control-label sp3">收货人姓名：</label>
                <div class="col-xs-3 sp1">
                    <input type="text" class="form-control" name="goods_name" placeholder="必填"/>
                </div>
            </div>

            <!--第三行-->
            <div class="row">
                <label class="col-xs-2 control-label sp3">收货人电话：</label>
                <div class="col-xs-3 sp1">
                    <input type="text" class="form-control" name=goods_tel placeholder="必填"/>
                </div>


            </div>

            <!--第四行-->
            <div class="row">
                <label class="col-xs-2 control-label sp3">收货人地址：</label>
                <div class="col-xs-3 sp1">
                    <input type="text" class="form-control" name="goods_address" placeholder="必填"/>
                </div>
            </div>

            <!--第五行-->
            <div class="row">
                <label class="col-xs-2 control-label sp3">发货描述信息：</label>
                <div class="col-xs-8 sp1">
							<textarea class="form-control sp4" name="describer" rows="10" cols="30"
                                      placeholder="选填"></textarea>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-4 col-xs-offset-5 sp1">
                    <input class="btn btn-default" type="submit" id="ok" value="发货">
                    <input class="btn btn-default" type="reset" id="reset" value="重置"/>
                </div>
            </div>
        </form>

    </div>
    <script type="text/javascript">
        $(function () {
            $("#ok").click(function () {
				var goods_address = $("input[name='goods_address']").val();
				var goods_tel = $("input[name='goods_tel']").val();
				var goods_name = $("input[name='goods_name']").val();
				if(goods_name==null){
					alert("您未填写收货人姓名")
					return false;
				}else if(goods_tel==null){
					alert("您未填写收货人电话")
					return false;
				}else if(goods_address==null){
					alert("您未填写收货人地址")
					return false;
				}
                return confirm("您确定要添加该发货单吗?");
            });
            $("#reset").click(function () {
                return confirm("您确定要重置该发货单吗?");
            });
        });
    </script>


    <div class="row text-center row_position">
        <span>物流配货系统.Copyright &copy;2021</span>
    </div>


</div>
<script src="static/script/jquery-3.5.1.min.js"></script>
<script src="static/script/bootstrap.min.js"></script>
</body>
</html>
