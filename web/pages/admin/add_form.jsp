<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>物流配货系统add_form</title>
    <%@ include file="/pages/common/header.jsp" %>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet"/>
    <script src="static/js/jquery-3.5.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/jquery-3.5.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/change_pwd.js"></script>
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
                <a class="btn btn-default btn-lg" href="javascript:void(0);" style="background-color: #d8fffd">
                    新增发货单
                </a>
            </li>
        </ul>
    </div>


    <div class="row dividing_line font_style sp1">
        首页 >> 新增发货单
    </div>

    <div class="border_gray">
        <form action="adminServlet?action=dealNewGood" method="post" class="form-horizontal">
            <!--第一行-->
            <div class="row">


                <label class="col-xs-2 control-label sp3">发货单号：</label>
                <div class="col-xs-3 sp1">
                    <input type="text" class="form-control" name="goods_id" placeholder="必填"
                           value="${sessionScope.goods_id}" disabled="disabled"/>
                </div>
                <label class="col-xs-2 col-xs-offset-1 control-label sp3">发货客户：</label>
                <div class="col-xs-3 sp1">
                    <input type="text" class="form-control updateCars" name="customer_user"
                           value="${param.customer_user}" placeholder="必填"/>
                </div>

            </div>

            <!--第二行-->
            <div class="row">

                <label class="col-xs-2 control-label sp3">收货人电话：</label>
                <div class="col-xs-3 sp1">
                    <input type="text" class="form-control" name=goods_tel value="${param.goods_tel}" placeholder="必填"/>
                </div>


                <label class="col-xs-2 col-xs-offset-1 control-label sp3">收货人姓名：</label>
                <div class="col-xs-3 sp1">
                    <input type="text" class="form-control" name="goods_name" value="${param.goods_name}"
                           placeholder="必填"/>
                </div>
            </div>

            <!--第三行-->
            <div class="row">
                <label class="col-xs-2 control-label sp3">收货人地址：</label>
                <div class="col-xs-3 sp1">
                    <input type="text" class="form-control updateCars" name="goods_address"
                           value="${param.goods_address}" placeholder="必填"/>
                </div>

                <label class="col-xs-2 col-xs-offset-1 control-label sp3">车辆选择：</label>
                <div class="col-xs-3 sp1">
                    <select class="form-control" name="car_number" id="cars">
                        <c:forEach items="${sessionScope.cars}" var="car">
                            <option value="${car.car_number}">${car.car_number}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!--第四行-->
            <div class="row">
                <label class="col-xs-2 control-label sp3">发货时间：</label>
                <div class="col-xs-3 sp1">
                    <input type="date" class="form-control" name="startTime" value="${param.startTime}"
                           placeholder="必选"/>
                </div>

                <label class="col-xs-2 col-xs-offset-1 control-label sp3">收货时间：</label>
                <div class="col-xs-3 sp1">
                    <input type="date" class="form-control" name="endTime" value="${param.endTime}" placeholder="必选"/>
                </div>
            </div>

            <!--第五行-->
            <div class="row">
                <label class="col-xs-2 control-label sp3">发货描述信息：</label>
                <div class="col-xs-8 sp1">
							<textarea class="form-control sp4" name="describer" rows="10" cols="30"
                                      placeholder="选填">${param.describer}</textarea>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-4 col-xs-offset-5 sp1">
                    <input class="btn btn-default" id="ok" type="submit" value="发货">
                    <input class="btn btn-default" type="reset" value="重置"/>
                </div>
            </div>

            <script type="text/javascript">
                $(function () {
                    $("#ok").click(function () {
                        var customer_user = $("input[name='customer_user']").val();
                        var goods_address = $(this).val();
                        var goods_tel = $("input[name='goods_tel']").val();
                        var goods_name = $("input[name='goods_name']").val();
                        // var car_numbers = $("#cars").children();
                        if (customer_user === "") {
                            alert("您还未填写：发货客户");
                            return false;
                        } else if (goods_tel === "") {
                            alert("您还未填写：收货人电话");
                            return false;
                        } else if (goods_name === "") {
                            alert("您还未填写：收货人姓名");
                            return false;
                        } else if (goods_address === "") {
                            alert("您还未填写：收货人地址");
                            return false;
                        }
                        return confirm("你确定要添加该发货单吗?");
                    });
                });
            </script>

        </form>

    </div>
    <%--    <script type="text/javascript">--%>
    <%--        $(function () {--%>
    <%--            $("#updateCars").change(function () {--%>
    <%--                var customer_user = $("input[name='customer_user']").val();--%>
    <%--                var goods_address = $(this).val();--%>
    <%--                var goods_tel = $("input[name='goods_tel']").val();--%>
    <%--                var goods_name = $("input[name='goods_name']").val();--%>
    <%--                var startTime = $("input[name='startTime']").val();--%>
    <%--                var endTime = $("input[name='endTime']").val();--%>
    <%--                var describer = $("textarea[name='customer_user']").val();--%>
    <%--                // var goods_id=$("input[name='goods_id']").val();--%>

    <%--                if (customer_user != "") {--%>
    <%--                    location.href = "http://localhost:8080/logistics/" + "adminServlet?action=updateCars&customer_user=" +--%>
    <%--                        customer_user + "&goods_address=" + goods_address +--%>
    <%--                        "&goods_tel=" + goods_tel + "&goods_name=" + goods_name + "&startTime=" + startTime +--%>
    <%--                        "&endTime=" + endTime + "&describer" + describer;--%>
    <%--                }--%>
    <%--            });--%>
    <%--            $("input[name='customer_user']").change(function () {--%>
    <%--                var customer_user = $(this).val();--%>
    <%--                var goods_address = $("input[name='goods_address']").val();--%>
    <%--                var goods_tel = $("input[name='goods_tel']").val();--%>
    <%--                var goods_name = $("input[name='goods_name']").val();--%>
    <%--                var startTime = $("input[name='startTime']").val();--%>
    <%--                var endTime = $("input[name='endTime']").val();--%>
    <%--                var describer = $("textarea[name='customer_user']").val();--%>

    <%--                if (goods_address != "") {--%>
    <%--                    location.href = "http://localhost:8080/logistics/" + "adminServlet?action=updateCars&customer_user=" +--%>
    <%--                        customer_user + "&goods_address=" + goods_address +--%>
    <%--                        "&goods_tel=" + goods_tel + "&goods_name=" + goods_name + "&startTime=" + startTime +--%>
    <%--                        "&endTime=" + endTime + "&describer" + describer;--%>
    <%--                }--%>
    <%--            });--%>
    <%--        });--%>
    <%--    </script>--%>

    <script type="text/javascript">
        $(function () {
            $(".updateCars").change(function () {
                var customer_user = $("input[name='customer_user']").val();
                var goods_address = $("input[name='goods_address']").val();
                var cars = $("#cars");
                var ok_btn = $("#ok");
                if (customer_user !== '' && goods_address !== '') {
                    $.getJSON("adminServlet", "action=updateCars&customer_user=" + customer_user + "&goods_address=" + goods_address, function (data) {
                        // alert(data);
                        console.log(data);
                        cars.empty();
                        if (data.length === 0) {
                            cars.append($("<option></option>").text("没有合适车辆"))
                            ok_btn.prop({"disabled":true});
                        } else {
                            ok_btn.prop({"disabled":false});
                            for (var i = 0; i < data.length; i++) {
                                var car_number = data[i].car_number;
                                cars.append($("<option></option>").text(car_number).val(car_number));
                            }
                        }
                    });
                }
            });
        });
    </script>


    <div class="row text-center row_position">
        <span>物流配货系统.Copyright &copy;2021</span>
    </div>

</div>
</body>
</html>
