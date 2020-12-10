<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/3
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewcount</title>
</head>
<body>
<%
    //application 存
    Integer countApplication = (Integer) application.getAttribute("countApplication");
    if (countApplication == null) {
        countApplication = 1;
        application.setAttribute("countApplication", countApplication);
    } else {
        countApplication++;
        application.setAttribute("countApplication", countApplication);
    }

    //session 存
    Integer countSession = (Integer) session.getAttribute("countSession");
    if (countSession == null) {
        countSession = 1;
        session.setAttribute("countSession", countSession);
    } else {
        countSession++;
        session.setAttribute("countSession", countSession);
    }


%>
<%="第" + countApplication + "次访问（Application）"%>
<br>
<%="第" + countSession + "次访问（Session）"%>

</body>
</html>
