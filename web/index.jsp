<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/10/20
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>我的第一个java应用</h1>
<%
    String idStr = request.getParameter("id");
    Integer id = Integer.parseInt(idStr);
    id++;
    //将数据存入到request中
    request.setAttribute("id", id);
    out.println(id);
    //将请求转发给test2.jsp
    request.getRequestDispatcher("test2.jsp").forward(request, response);

%>
</body>
</html>