<%@ page import="com.el.User" %><%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/3
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User(1, "fsfs", 4);
    pageContext.setAttribute("user", user);
%>
<h1>${user}</h1>

${user.nam}
${user.nam}

</body>
</html>
