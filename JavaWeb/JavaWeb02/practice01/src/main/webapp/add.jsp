<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>

<style>
    body{
        background-image: url("bg.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>

<body style="margin-left: 40%;margin-top: 10%;margin-right: 40%">

<%--用a标签--%>
<div style="text-align: center;height: 500px">
    <form action="${pageContext.request.contextPath}/update.do?method=add" method="post">
        <p>学号：<input type="text" name="id" required oninput="value=value.replace(/[^\d]/g,'')" maxlength="12"></p>
        <p>姓名：<input type="text" name="name" required maxlength="30"></p>
        <p>班级：<input type="text" name="classname" required maxlength="30"></p>
        <p>性别：
            <input type="radio" value="男" name="gender">男
            <input type="radio" value="女" name="gender">女
        </p>

        <p>
            <input type="submit">
            <input type="reset">
        </p>

    </form>
    <a href="Welcome.jsp">
        <button>回到首页</button>
    </a>
</div>


</body>
</html>
