<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/23
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传下载</title>
</head>
<body>
<form enctype="multipart/form-data" action="/upload" method="post">
    <input type="file" name="img"/><br/>
    <input type="file" name="text"><br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
