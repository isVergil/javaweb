<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/3
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>page1</h1>
<%
    application.setAttribute("name", "tom");
    application.getRequestDispatcher("target.jsp").forward();
%>
<%
    String name = (String) application.getAttribute("name");
    out.write(name);
%>

</body>
</html>
