<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/24
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String path=request.getScheme()+
            "://"+
            request.getServerName()+
            ":"+
            request.getServerPort()+
            request.getContextPath()+
            "/";
    pageContext.setAttribute("basePath",path);
%>
<base href="<%=path%>">
</body>
</html>
