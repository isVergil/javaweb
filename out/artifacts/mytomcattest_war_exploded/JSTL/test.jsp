<%@ page import="com.el.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/4
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--c表示标签前缀--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="border: 1px">

    <%
        List<User> users = (List<User>) request.getAttribute("users");
        for (User user : users) {
            request.setAttribute("user", user);
    %>
    <tr>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.number}</td>
    </tr>
    <%
        }
    %>
    <hr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.number}</td>
        </tr>
    </c:forEach>

    <c:forEach items="${users}" var="user">
        ${user.name}<br/>
    </c:forEach>
    <h1>系统时间</h1>
    <%
        request.setAttribute("date", new Date());
    %>
    ${date}<br/>
    <fmt:formatDate value="${date}" pattern="yyyy-mm-dd HH:mm:ss"></fmt:formatDate>
    <fmt:formatNumber value="3548151.15641" maxFractionDigits="3" maxIntegerDigits="2"></fmt:formatNumber>

    <br/>
    <%
        request.setAttribute("info", "java.c");
    %>
    ${fn:contains(info,"c")}
    ${fn:startsWith(info,"c")}
    ${fn:endsWith(info,"c")}
    ${fn:indexOf(info,"c")}
    ${fn:replace(info,"c","python")}
    <hr>
    <%--    <%--%>
    <%--        User userTest = new User(2, "发顺丰", 6);--%>
    <%--    %>--%>
    <%--    <c:set var="name" value="tom" scope="request"></c:set>--%>
    <%--    <c:set target="${userTest}" property="name" value="李四"></c:set>--%>
    <%--    <c:out value="${userTest.name}" default="未定义"></c:out>--%>
    <%--    <c:remove  var="${name}" scope="page"></c:remove>--%>

    <%--    <c:catch var="error">--%>
    <%--        <%--%>
    <%--            int a = 10 / 0;--%>
    <%--        %>--%>
    <%--    </c:catch>--%>

    <c:if test="${user.age>user.number}">ok</c:if>

    <c:choose>
        <c:when test="${user.age>user.number}">ok</c:when>
        <c:otherwise>fail</c:otherwise>
    </c:choose>
</table>

</body>
</html>
