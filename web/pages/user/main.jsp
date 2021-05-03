<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>物流配货系统main</title>
		<%@include file="/pages/common/header.jsp"%>
		<link href="static/css/bootstrap.min.css" rel="stylesheet">
		<link href="static/css/style.css" rel="stylesheet" />
	</head>
	<body>


		<div class="container-fluid">

			<div class="text-right dividing_line row_position">
				<span>欢迎<span class="name_font">${sessionScope.clientName}</span>使用本系统</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0);">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="clientServlet?action=logout">退出系统</a>
			</div>

			<div class="row text-right dividing_line">
				<ul class="list-inline">
					<li>
						<a class="btn btn-default btn-lg" href="/logistics/clientServlet?action=page">我的发货单</a>
					</li>
					<li>
						<a class="btn btn-default btn-lg" href="pages/user/add_form.jsp">填写发货单</a>
					</li>
				</ul>
			</div>


			<div class="row dividing_line font_style sp1">
				首页 
			</div>

			<div class="border_style border_gray"></div>

			<div class="row text-center row_position">
				<span>物流配货系统.Copyright &copy;2021</span>
			</div>



		</div>
		<script src="static/js/jquery-3.5.1.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
	</body>
</html>
