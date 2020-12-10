<%@ page import="java.util.List" %>
<%@ page import="com.el.User" %><%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/4
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userlist</title>
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
</table>
</body>
</html>
