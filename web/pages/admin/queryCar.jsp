<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>物流配货系统query</title>
    <%@include file="/pages/common/header.jsp" %>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet"/>
    <script src="static/js/jquery-3.5.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container-fluid">

    <%@include file="/pages/common/welcome_message.jsp"%>

    <div class="row text-right dividing_line">
        <ul class="list-inline">
            <li>
                <a class="btn btn-default btn-lg" href="adminServlet?action=queryGoods">发货单查询</a>
            </li>
            <li>
                <a class="btn btn-default btn-lg" href="/logistics/adminServlet?action=getNewGoods">新增发货单</a>
            </li>
            <li>
                <a class="btn btn-default btn-lg" href="pages/admin/addCar.jsp">增加车源信息</a>
            </li>
        </ul>
    </div>


    <div class="row dividing_line font_style sp1">
        车源信息管理：
    </div>


    <div class="border_gray">

        <table class="table table-hover" style="text-align: center;">
            <c:if test="${not empty requestScope.page.items}">
<%--                <%int num = Integer.parseInt(request.getParameter("pageSize"));%>--%>
                <c:forEach items="${requestScope.page.items}" var="item">
<%--                    <%num--;%>--%>
                    <tr>
                        <td width="5%">序号</td>
                        <td width="5%">姓名</td>
                        <td width="10%">车牌号</td>
                        <td width="20%">地址</td>
                        <td width="10%">电话</td>
                        <td width="20%">身份证号</td>
                        <td width="10%">运输路线</td>
                        <td width="10%">车辆描述</td>
                        <td width="10%">操作</td>
                    </tr>
                    <tr>
                        <td width="5%">${item.id}</td>
                        <td width="5%">${item.username}</td>
                        <td width="10%">${item.car_number}</td>
                        <td width="20%">${item.address}</td>
                        <td width="10%">${item.tel}</td>
                        <td width="20%">${item.car_number}</td>
                        <td width="10%">${item.car_road}</td>
                        <td width="10%"><span><a tabindex="0" class="pop_info font_color btn btn-default btn-xs"
                                                 role="button"
                                                 data-toggle="popover" data-trigger="focus" id="example"
                                                 data-content=
                                                         <c:if test="${item.car_content==null}">"没有车辆描述"</c:if>
                                <c:if test="${item.car_content!=null}">
                                    ${item.car_content}
                                </c:if>
                        >查看</a></span></td>
                        <td width="10%">
                            <a href="adminServlet?action=getUpdateCar&id=${item.id}">修改</a>
                            <a href="adminServlet?action=deleteCar&id=${item.id}" class="delete">删除</a>
                        </td>
                    </tr>
<%--                                        <%if (num > 0) {%>--%>
                    <tr style="height: 40px;">
                        <td width="5%"></td>
                        <td width="5%"></td>
                        <td width="10%"></td>
                        <td width="20%"></td>
                        <td width="10%"></td>
                        <td width="20%"></td>
                        <td width="10%"></td>
                        <td width="10%"></td>
                        <td width="10%">
                        </td>
                    </tr>
<%--					<% } %>--%>
                </c:forEach>
            </c:if>
            <c:if test="${empty requestScope.page.items}">
                <h1 align="center">没有车源信息</h1>
            </c:if>
        </table>
        <script type="text/javascript">
            $(function () {
                $(".delete").click(function () {
                    return confirm("你确定要删除该车源吗?");
                });
            });
        </script>

        <%@include file="/pages/common/page_nav.jsp" %>

    </div>


    <div class="row text-center row_position">
        <span>物流配货系统.Copyright &copy;2021</span>
    </div>


</div>
<script src="static/js/jquery-3.5.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/change_pwd.js"></script>
<script>
    $(function () {
        $(".pop_info").popover();
    });

</script>
</body>
</html>
