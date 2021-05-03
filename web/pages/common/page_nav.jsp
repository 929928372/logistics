<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/20
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.page.pageTotal<=5}">
        <c:set var="begin" value="1"/>
        <c:set var="end" value="${requestScope.page.pageTotal}"/>
    </c:when>

    <c:when test="${requestScope.page.pageTotal>5}">
        <c:choose>
            <c:when test="${requestScope.page.pageNo<=3}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="5"/>
            </c:when>
            <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                <c:set var="end" value="${requestScope.page.pageTotal}"/>
            </c:when>
            <c:otherwise>
                <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                <c:set var="end" value="${requestScope.page.pageNo+2}"/>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>

<nav class="text-center" aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach begin="${begin}" end="${end}" var="i">
            <c:if test="${i==requestScope.page.pageNo}">
                <li class="active">
                    <a href="javascript:void(0);"> ${i} </a>
                </li>
            </c:if>
            <c:if test="${i!=requestScope.page.pageNo}">
                <li>
                    <a href="${requestScope.page.url}&pageNo=${i}"> ${i} </a>
                </li>
            </c:if>
        </c:forEach>
        <li>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>
</html>
