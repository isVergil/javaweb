<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/10/22
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
<h1>欢迎</h1>
<%
    String name = (String) request.getAttribute("loginID");
    String psw = (String) request.getAttribute("psw");
    String sessionID=session.getId();
%>
<%=sessionID%>
用户<%=name%><br>
密码<%=psw%>

</body>
</html>
