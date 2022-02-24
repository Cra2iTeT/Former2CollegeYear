<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息登记</title>
</head>

<body>

<div>
    <form action="${pageContext.request.contextPath}/admin.do?method=addStu" method="post">
        <p>学号：
            <input type="text" name="sid" maxlength="8" oninput="value=value.replace(/[^\d]/g,'')">
        </p>
        <p>姓名：
            <input type="text" name="sname" maxlength="30">
        </p>
        <p>性别：
            <input type="radio" name="sgender" value="男">男
            <input type="radio" name="sgender" value="女">女
        </p>
        <p>所在班级：
            <input type="text" name="sclass" maxlength="30">
        </p>
        <p>所属专业：
            <input type="text" name="smajor" maxlength="30">
        </p>
        <p>
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </p>
    </form>
    <a href="admin.jsp">
        <button>回到首页</button>
    </a>
</div>
</body>
</html>
