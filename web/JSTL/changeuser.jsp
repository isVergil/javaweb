<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/6
  Time: 4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="/users" method="post">
    姓名：<input type="text" name="name" value="${changeuser.name}"><br>
    年纪：<input type="text" name="age" value="${changeuser.age}"><br>
    号码：<input type="text" name="number" value="${changeuser.number}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
