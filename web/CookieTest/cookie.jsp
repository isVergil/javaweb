<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/10/23
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<%
    //Cookie cookie = new Cookie("name", "张三");
    //通过响应传 cookie
    //response.addCookie(cookie);
    Cookie[] cookies = request.getCookies();
//    for (Cookie cookie : cookies) {
//        out.write(cookie.getName() + "  " + cookie.getValue() + "<br/>");
//    }
    out.write(cookies[0].getMaxAge());


%>
</body>
</html>
