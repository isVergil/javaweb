<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/10/22
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%
String sessionID=session.getId();
%>
<%=sessionID%>
<%
    String loginID = request.getParameter("loginID");
    String psw = request.getParameter("psw");
    if (loginID.equals("admin") && psw.equals("123")) {
        //登陆成功
        request.setAttribute("loginID", loginID);
        request.setAttribute("psw", psw);
        request.getRequestDispatcher("/LoginTest/welcome.jsp").forward(request, response);
    } else {
        //重定向
        response.sendRedirect("/LoginTest/login.jsp");

    }

%>

</body>
</html>
