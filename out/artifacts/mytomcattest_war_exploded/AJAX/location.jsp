<%--
  Created by IntelliJ IDEA.
  User: bill
  Date: 2020/12/3
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市区 联动下拉框</title>
    <script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //修改省
            $("#province").change(function () {
                var id = $(this).val();
                $.ajax({
                    url: "/location",
                    type: "post",
                    data: "id=" + id + "&type=province",
                    dataType: "JSON",
                    success: function (data) {
                        console.log(data);
                        var contentCitys = "";
                        var contentAreas = "";
                        var flag = 0;
                        for (var i = 0; i < data.length; i++) {
                            if (data[i] == "") {
                                for (flag = i + 1; flag < data.length; flag++) {
                                    contentAreas += "<option>" + data[flag] + "</option>";
                                }
                                break;
                            }
                            flag++;
                            contentCitys += "<option>" + data[i] + "</option>";
                        }
                        $("#city").html(contentCitys);
                        $("#area").html(contentAreas);
                    }
                })
            })

            //修改城市
            $("#city").change(function () {
                var id = $(this).val();
                $.ajax({
                    url: "/location",
                    type: "post",
                    data: "id=" + id + "&type=city",
                    dataType: "JSON",
                    success: function (data) {
                        console.log(data);
                        var content = "";
                        for (var i = 0; i < data.length; i++) {
                            content += "<option>" + data[i] + "</option>";
                        }
                        $("#area").html(content);

                    }
                })
            })
        });
    </script>
</head>
<body>
省：<select name="" id="province">
    <option value="陕西省">陕西省</option>
    <option value="河南省">河南省</option>
    <option value="江苏省">江苏省</option>
    <option value="湖北省">湖北省</option>
    <option value="湖南省">湖南省</option>
</select>
市：<select name="" id="city">
    <option value="西安市">西安市</option>
    <option value="宝鸡市">宝鸡市</option>
    <option value="渭南市">渭南市</option>
</select>
区：<select name="" id="area">
    <option value="">雁塔区</option>
    <option value="">莲湖区</option>
    <option value="">新城区</option>
</select>

</body>
</html>
