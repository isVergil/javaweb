<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/10/22
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/LoginTest/check.jsp" method="post">
    <p>用户名：<input type="text" name="loginID"></p>
    <p>密码：<input type="password" name="psw"></p>
    <p><input type="submit" value="登录"></p>
</form>
<%
    String sessionID=session.getId();
    int interval=session.getMaxInactiveInterval();
%>
<%=sessionID%>
<%=interval%>



<script>


</script>
</body>
</html>
