<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/10/22
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forward</title>
</head>
<body>
<%
    request.setAttribute("id", "15");
    //response.sendRedirect("test2.jsp");
    request.getRequestDispatcher("test2.jsp").forward(request, response);
%>

</body>
</html>
