<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/10/21
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test2</title>
</head>
<body>
<h1>test2</h1>
<%
    String name = (String) request.getAttribute("id");
    out.write(name);
%>
</body>
</html>
