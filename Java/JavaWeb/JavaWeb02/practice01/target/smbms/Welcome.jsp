<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增删改查系统</title>
</head>

<style>
    body{
        background-image: url("bg.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>

<body>

<div style="text-align: center">
    <p>欢迎来到Cra2iTeT的增删改查系统</p>
    <form action="add.jsp" method="post">
        <input type="submit" value="添加">
    </form>
    <form action="query.jsp" method="post">
        <input type="submit" value="查找">
    </form>
    <form action="${pageContext.request.contextPath}/update.do?method=allQuery" method="post">
        <input type="submit" value="显示">
    </form>

</div>

</body>
</html>
