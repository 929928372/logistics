<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>物流配货系统query1.0</title>
    <%@include file="/pages/common/header.jsp" %>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet"/>
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
                <a class="btn btn-default btn-lg" href="clientServlet?action=page">我的发货单</a>
            </li>
            <li>
                <a class="btn btn-default btn-lg" href="pages/user/add_form.jsp">填写发货单</a>
            </li>
        </ul>
    </div>


    <div class="row dividing_line font_style sp1">
        首页 >> 发货单查询
    </div>


    <div class="row border_gray">
        <c:if test="${not empty requestScope.page.items}">
            <table class="table table-hover" style="table-layout: fixed">
                <tr>
                    <td>订单编号</td>
                    <td>收货人姓名</td>
                    <td>收货人电话</td>
                    <td>收货人地址</td>
                    <td>发货状态</td>
                    <td>发货时间</td>
                    <td>描述信息</td>
                </tr>
                <c:forEach begin="0" end="${fn:length(requestScope.page.items)-1}" var="i">
                    <tr>
                        <td>${requestScope.page.items[i].goods_id}</td>
                        <td>${requestScope.page.items[i].goods_name}</td>
                        <td>${requestScope.page.items[i].goods_tel}</td>
                        <td>${requestScope.page.items[i].goods_address}</td>
                        <td>
                            <c:if test="${empty requestScope.page.items[i].car_id}">
                                <span style="color: #ff0714">未发货</span>
                            </c:if>
                            <c:if test="${not empty requestScope.page.items[i].car_id}">
                                已发货
                            </c:if>
                        </td>
                        <td>${requestScope.carlogs[i].startTime}</td>
                        <td>
                            <span><a tabindex="0" class="pop_info font_color btn btn-default btn-xs" role="button"
                                     data-toggle="popover" data-trigger="focus"
                                     data-content=
                                             <c:if test="${requestScope.carlogs[i].describer==null}">"无更多描述"</c:if>
                                    <c:if test="${requestScope.carlogs[i].describer!=null}">
                                        ${requestScope.carlogs[i].describer}
                                    </c:if>>查看</a></span>
                        </td>
                    </tr>
                    <!--分割线-->
<%--                    <div class="dividing_line_"></div>--%>

                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty requestScope.page.items}">
            <h1 align="center">您还未有发货单</h1>
        </c:if>

        <div class="dividing_line row_position"></div>

        <%@include file="/pages/common/page_nav.jsp"%>

    </div>


    <div class="row text-center row_position">
        <span>物流配货系统.Copyright &copy;2021</span>
    </div>


</div>
<script src="static/js/jquery-3.5.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $(".pop_info").popover();
    });
</script>
</body>
</html>
