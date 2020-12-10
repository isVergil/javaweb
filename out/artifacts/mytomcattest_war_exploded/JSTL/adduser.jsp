<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/5
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users" method="post">
    姓名：<input type="text" name="name"><br>
    年纪：<input type="text" name="age"><br>
    号码：<input type="text" name="number"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
