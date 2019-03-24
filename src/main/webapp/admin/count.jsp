<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>刷新缓存</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>

</head>
<body>
    网站总访问人数:${count}<br>
    <button id="refresh" type="button">刷新缓存</button>
    <script>
        $("#refresh").click(function(){
            $.ajax({url:"${pageContext.request.contextPath}/admin/refresh.action",success:function (success) {
                    if(success){
                        alert("刷新成功");
                    }else {
                        alert("刷新失败");
                    }
                }});
        });

    </script>
</body>
</html>
