<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/11/24
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var btn=$("#btn");
            btn.click(function () {
                $.ajax({
                    //url 相当于servlet
                    url:'/ajaxtest',
                    type:'post',
                    //参数
                    data:'id=1',
                    //服务器返回类型
                    dataType:'text',
                    //由于后台写的返回是 test.jsp 故此时返回的是 整个 test.jsp 的前台代码
                    success:function (data) {
                        var text=$('#text');
                        text.before("<span>"+data+"</span>");

                    },
                    error:function () {
                        alert("服务器维护中...");
                    },
                    complete:function () {
                        alert("请求完成...");
                    }
                });
            });
        })
    </script>

</head>
<body>
${str}

    <input id="text" type="text"><br>
    <input id="btn" type="button" value="提交">
</body>
</html>
