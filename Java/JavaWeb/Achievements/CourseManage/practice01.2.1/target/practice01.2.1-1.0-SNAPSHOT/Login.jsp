<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<div>
    <form  action="${pageContext.request.contextPath}/login.do" method="post">
        <p>账号：
            <input type="text" name="code">
        </p>
        <p>
            <input type="radio" name="role" value="管理员">管理员
            <input type="radio" name="role" value="教师">教师
            <input type="radio" name="role" value="学生">学生
        </p>
        <p>
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </p>
    </form>
</div>
</body>
</html>
