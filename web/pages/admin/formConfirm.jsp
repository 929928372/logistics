<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	</head>
	<body>


		<div class="container-fluid">

			<%@include file="/pages/common/welcome_message.jsp"%>


			<div class="row dividing_line font_style sp1">
				首页 >> 回执发货单确认
			</div>

			<div class="border_gray">
				
				<table class="table table-hover">
					<tr>
						<td>车主姓名：</td>
						<td>${requestScope.car.username}</td>
						<td>车牌号码</td>
						<td>${requestScope.car.car_number}</td>
					</tr>
					<tr>
						<td>车主地址：</td>
						<td>${requestScope.car.address}</td>
						<td>车主电话：</td>
						<td>${requestScope.car.tel}</td>
					</tr>
					<tr>
						<td>运输路线</td>
						<td>${requestScope.car.car_road}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>发货人姓名：</td>
						<td>${requestScope.customer.customer_user}</td>
						<td>发货人电话：</td>
						<td>${requestScope.customer.customer_tel}</td>
					</tr>
					<tr>
						<td>发货人地址：</td>
						<td>${requestScope.customer.customer_address}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>收货人姓名：</td>
						<td>${requestScope.good.goods_name}</td>
						<td>收货人电话：</td>
						<td>${requestScope.good.goods_tel}</td>
					</tr>
					<tr>
						<td>收货人地址：</td>
						<td>${requestScope.good.goods_address}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>发货时间：</td>
						<td>${requestScope.carlog.startTime}</td>
						<td>收获时间</td>
						<td>${requestScope.carlog.endTime}</td>
					</tr>
					<tr>
						<td>发货单号：</td>
						<td>${requestScope.good.goods_id}</td>
						<td>货物描述：</td>
						<td>${requestScope.carlog.describer}</td>
					</tr>
					<tr>
						<td colspan="3" align="right">
							<a href="adminServlet?action=confirmGoods&goods_id=${requestScope.good.goods_id}" class="btn btn-default">确认</a>
						</td>
						<td align="left">
							<a href="adminServlet?action=queryGoods" class="btn btn-default">返回</a>
						</td>
					</tr>
				</table>
				

			</div>



			<div class="row text-center row_position">
				<span>物流配货系统.Copyright &copy;2021</span>
			</div>



		</div>
		<script src="static/js/jquery-3.5.1.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/change_pwd.js"></script>
	</body>
</html>
