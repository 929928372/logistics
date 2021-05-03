<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>物流配货系统query_manager</title>
    <%@include file="/pages/common/header.jsp" %>
    <script src="static/js/jquery-3.5.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/change_pwd.js"></script>
<%--    <script src="static/js/jquery.combo.select.js"></script>--%>
    <script src="static/js/select.js"></script>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet"/>
<%--    <link href="static/css/combo.select.css" rel="stylesheet"/>--%>
    <link href="static/css/test.css" rel="stylesheet"/>
</head>
<body>


<div class="container-fluid">
    <%@include file="/pages/common/welcome_message.jsp"%>
</div>

<div class="row text-right dividing_line">
    <form class="sp5 navbar-form navbar-left " action="adminServlet?action=queryGoodsByKeyWord" method="post" id="search_form"
          style="padding-left:40%;padding-bottom: 1%;">
        <div class="wyInput text-left" id="myInput">
            <div class="wyinput-group">
                <input type="text" name="keyWord" value="${sessionScope.keyWord}" placeholder="请输入关键字" class="form-control search">
                <input type="submit" class="wyinput-btn btn btn-default" id="search_ok" value="搜索">
                <script type="text/javascript">
                    $('#search_form').submit(function () {
                        // 搜索内容不能为空
                        if($('input[name="keyWord"]').val().trim()===""){
                            return false;
                        }
                    })
                </script>
            </div>
            <div class="wyinput-drop"></div>
        </div>
    </form>
    <ul class="list-inline" style="margin-top: 8px">
        <li>
            <a class="btn btn-default btn-lg" href="adminServlet?action=queryGoods"
               style="background-color: #d8fffd">
                发货单查询
            </a>
        </li>
        <li>
            <a class="btn btn-default btn-lg" href="/logistics/adminServlet?action=getNewGoods">新增发货单</a>
        </li>
        <li>
            <a class="btn btn-default btn-lg" href="/logistics/adminServlet?action=queryCars">查询车源信息</a>
        </li>
    </ul>
</div>


<div class="row dividing_line font_style sp1">
    首页 >> 发货单查询
    <div class="btn-group">
        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            查询条件 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="adminServlet?action=queryForUndoGoods">未发货</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="adminServlet?action=queryUnConfirmGoods">未确认</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="adminServlet?action=queryHaveDoneGoods">已确认</a></li>
        </ul>
    </div>
</div>


<div class="border_gray">

    <c:if test="${requestScope.page.items==null}">
        <h1 align="center">没有该数据</h1>
    </c:if>
    <c:if test="${requestScope.page.items!=null}">
        <c:forEach begin="0" end="${fn:length(requestScope.page.items)-1}" var="i">
            <table class="table table-hover" style="table-layout: fixed">
                <tr>
                    <td>车主姓名：<span>${requestScope.cars[i].username}</span></td>
                    <td>车牌号码：<span>${requestScope.cars[i].car_number}</span></td>
                    <td>车主地址：<span>${requestScope.cars[i].address}</span></td>
                    <td>车主电话：<span>${requestScope.cars[i].tel}</span></td>
                    <td>运输路线：<span>${requestScope.cars[i].car_road}</span></td>
                </tr>
                <tr>
                    <td>发货人姓名：<span>${requestScope.customers[i].customer_user}</span></td>
                    <td>发货人电话：<span>${requestScope.customers[i].customer_tel}</span></td>
                    <td>发货人地址：<span>${requestScope.customers[i].customer_address}</span></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>订单编号：<span>${requestScope.page.items[i].goods_id}</span></td>
                    <td>收货人姓名：<span>${requestScope.page.items[i].goods_name}</span></td>
                    <td>收货人电话：<span>${requestScope.page.items[i].goods_tel}</span></td>
                    <td>收货人地址：<span>${requestScope.page.items[i].goods_address}</span></td>
                    <td></td>
                </tr>
                <tr>
                    <td>发货时间：<span>${requestScope.carlogs[i].startTime}</span></td>
                    <td>收货时间：<span>${requestScope.carlogs[i].endTime}</span></td>
                    <td>货物描述：<span><a tabindex="0" class="pop_info font_color btn btn-default btn-xs" role="button"
                                      data-toggle="popover" data-trigger="focus"
                                      data-content=
                                              <c:if test="${requestScope.carlogs[i].describer==null}">"无更多描述"</c:if>
                            <c:if test="${requestScope.carlogs[i].describer!=null}">
                                ${requestScope.carlogs[i].describer}
                            </c:if>
                    >查看</a></span>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>发货状态：
                        <span>
                    <c:if test="${requestScope.cars[i]==null}">
                        <span style="color: #ff0000">未发货</span>
                    </c:if>
                    <c:if test="${requestScope.cars[i]!=null}">
                        <span>已发货</span>
                    </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </span>
                    </td>
                    <td>是否确认：
                        <span>
                    <c:if test="${requestScope.page.items[i].goods_sure==0}">
                        <span style="color: #ff0000">未确认</span>&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${requestScope.page.items[i].goods_sure==1}">
                        <span>已确认</span>&nbsp;&nbsp;
                    </c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </span>
                    </td>
                    <td></td>
                    <td></td>
                    <td>
                        <c:if test="${requestScope.cars[i]==null}">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="adminServlet?action=getUndoGoods&goods_id=${requestScope.page.items[i].goods_id}">
                                发货</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <%--                            <a href="">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                            <a href="adminServlet?action=deleteGoods&goods_id=${requestScope.page.items[i].goods_id}"
                               class="delete">删除</a>
                        </c:if>
                        <c:if test="${requestScope.cars[i]!=null&&requestScope.page.items[i].goods_sure==0}">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="adminServlet?action=getConfirmGoods&goods_id=${requestScope.page.items[i].goods_id}">确认</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="adminServlet?action=deleteGoods&goods_id=${requestScope.page.items[i].goods_id}"
                               class="delete">删除</a>
                        </c:if>
                        <c:if test="${requestScope.page.items[i].goods_sure==1}">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="adminServlet?action=deleteGoods&goods_id=${requestScope.page.items[i].goods_id}"
                               class="delete">删除</a>
                        </c:if>
                    </td>
                </tr>
            </table>
        </c:forEach>
    </c:if>

    <%@include file="/pages/common/page_nav.jsp" %>

</div>


<div class="row text-center row_position">
    <span>物流配货系统.Copyright &copy;2021</span>
</div>

</div>
<script>
    $(function () {
        $(".pop_info").popover();
    });
</script>
<script type="text/javascript">
    $(function () {
        $(".delete").click(function () {
            return confirm("你确定要删除该发货单吗?");
        });
    });
</script>
</body>
</html>
