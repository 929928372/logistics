<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="text-right dividing_line row_position">
    <c:if test="${sessionScope.adminName!=null}">
        <span>欢迎<span class="name_font">${sessionScope.adminName}</span>使用本系统</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${sessionScope.clientName!=null}">
        <span>欢迎<span class="name_font">${sessionScope.clientName}</span>使用本系统</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <button onclick="editPassword()" class="btn_my">修改密码</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="index.jsp">退出系统</a>

    <div class="modal fade" id="updatePassword" tabindex="-1" data-backdrop="static">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true" onclick="cancel()">&times;</span></button>
                    <h4 class="modal-title text-left" id="exampleModalLabel">密码修改</h4>
                </div>
                <div class="modal-body">
                    <form name="editForm" method="post">
                        <div class="form-group text-left">
                            <label for="recipient-name">原密码：</label>
                            <input type='password' id="oldpassword" class="form-control" name="oldpassword"
                                   required placeholder="原密码">
                        </div>
                        <div class="form-group text-left">
                            <label for="message-text">新密码:</label>
                            <input type='password' id="password1" name="password1" class="form-control"
                                   required placeholder="新密码">
                        </div>
                        <div class="form-group text-left">
                            <label for="message-text">再次输入:</label>
                            <input type='password' id="password2" name="password2" class="form-control"
                                   required placeholder="再次输入新密码">
                            <div style="display: inline" id="tip3"></div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button onclick="submitPassword()" class="btn btn-primary"
                            ng-disabled="editForm.$invalid">确定
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal"
                            onclick="cancel()">取消
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
