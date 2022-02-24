<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>

    <script>
        function a() {
            $.post({
                url: "${pageContext.request.contextPath}/a1",
                data: {"name": $("#userName").val()},
                success: function (data) {
                    alert(data);
                }
            })
        }

    </script>

</head>
<body>

<input type="text" id="userName" onblur="a()">

</body>
</html>
