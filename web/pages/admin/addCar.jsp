<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>物流配货系统add_form</title>
		<%@include file="/pages/common/header.jsp"%>
		<link href="static/css/bootstrap.min.css" rel="stylesheet">
		<link href="static/css/style.css" rel="stylesheet" />
		<script src="static/js/jquery-3.5.1.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
	</head>
	<body>


		<div class="container-fluid">

			<%@include file="/pages/common/welcome_message.jsp"%>

			<div class="row text-right dividing_line">
				<ul class="list-inline">
<%--					<li>--%>
<%--						<a class="btn btn-default btn-lg" href="adminServlet?action=queryGoods">发货单查询</a>--%>
<%--					</li>--%>
<%--					<li>--%>
<%--						<a class="btn btn-default btn-lg" href="/logistics/adminServlet?action=getNewGoods">新增发货单</a>--%>
<%--					</li>--%>
					<li>
						<a class="btn btn-default btn-lg" href="/logistics/adminServlet?action=queryCars">返回</a>
					</li>
				</ul>
			</div>


			<div class="row dividing_line font_style sp1">
				添加车源信息
			</div>

			<div class="border_gray">
				<form action="adminServlet?action=addCar" method="post" class="form-horizontal">
					<!--第一行-->
					<div class="row">
						<label class="col-xs-4 control-label">姓名：</label>
						<div class="col-xs-3 sp1">
							<input type="text" class="form-control" name="username" placeholder="必填" />
						</div>
					</div>

					<!--第二行-->
					<div class="row">
						<label class="col-xs-4 control-label">身份证号：</label>
						<div class="col-xs-3 sp1">
							<input type="text" class="form-control" name="user_number" placeholder="必填" />
						</div>
					</div>

					<!--第三行-->
					<div class="row">
						<label class="col-xs-4 control-label">地址：</label>
						<div class="col-xs-3 sp1">
							<input type="text" class="form-control" name="address" placeholder="必填" />
						</div>
					</div>

					<!--第四行-->
					<div class="row">
						<label class="col-xs-4 control-label">车牌号：</label>
						<div class="col-xs-3 sp1">
							<input type="text" class="form-control" name="car_number" placeholder="必填" />
						</div>
					</div>

					<!--第五行-->
					<div class="row">
						<label class="col-xs-4 control-label">电话：</label>
						<div class="col-xs-3 sp1">
							<input type="text" class="form-control" name="tel" placeholder="必填" />
						</div>
					</div>
					
					<div class="row">
						<label class="col-xs-4 control-label">运输路线：</label>
						<div class="col-xs-5 sp1">
							<textarea class="form-control sp4" name="car_road" rows="5" cols="20"
								placeholder="必填"></textarea>
						</div>
					</div>
					
					<div class="row">
						<label class="col-xs-4 control-label">车辆描述：</label>
						<div class="col-xs-5 sp1">
							<textarea class="form-control sp4" name="car_content" rows="5"
								placeholder="选填"></textarea>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-3 col-xs-offset-5 sp1">
							<input class="btn btn-default" type="submit" id="ok" value="添加">
							<input class="btn btn-default" type="reset" id="reset" value="重置" />
						</div>
					</div>
				</form>

			</div>



			<div class="row text-center row_position">
				<span>物流配货系统.Copyright &copy;2021</span>
			</div>

			<script type="text/javascript">
				$(function () {
					$("#ok").click(function () {
						var username = $("input[name='username']").val();
						var user_number = $("input[name='user_number']").val();
						var address = $("input[name='address']").val();
						var car_number = $("input[name='car_number']").val();
						var tel = $("input[name='tel']").val();
						var car_road = $("input[name='car_road']").val();

						// if(username==null){
						// 	alert("您未填写车主姓名")
						// 	return false;
						// }else if(user_number==null){
						// 	alert("您未填写车主身份证号")
						// 	return false;
						// }else if(address==null){
						// 	alert("您未填写车主地址(运输起点)")
						// 	return false;
						// }else if(car_number==null){
						// 	alert("您未填写车牌号")
						// 	return false;
						// }else if(tel==null){
						// 	alert("您未填写车主电话号码")
						// 	return false;
						// }else if(car_road==null){
						// 	alert("您未填写车辆运输路线")
						// 	return false;
						// }
						return confirm("您确定要添加该车源吗?");
					});
					$("#reset").click(function () {
						return confirm("您确定要重置该车源吗?");
					});
				});
			</script>


		</div>
		<script src="static/js/jquery-3.5.1.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/change_pwd.js"></script>
	</body>
</html>
