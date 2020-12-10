<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/10/23
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object a1 = request.getParameter("username");
    Object a2 = request.getParameter("psw");
//    Object a3 = request.getAttribute("username");
//    Object a4 = request.getAttribute("psw");

    Object a3 = session.getAttribute("username");
    Object a4 = session.getAttribute("psw");
%>

<%=a1%>
<%=a2%>
<%=a3%>
<%=a4%>
</body>
</html>
