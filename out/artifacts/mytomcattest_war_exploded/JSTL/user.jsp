<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/5
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thread>
        <th>姓名</th>
        <th>年纪</th>
        <th>号码</th>
        <th>操作</th>
    </thread>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.number}</td>
            <td>
                    <%-- href 是  get请求方式--%>
                <a href="/users?method=change&name=${user.name}&age=${user.age}&number=${user.number}">修改</a>
                <a href="/users?method=delete&name=${user.name}&age=${user.age}&number=${user.number}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
