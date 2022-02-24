<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息修改</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/do?method=execute" method="post">
        <p>户主姓名：
            <input type="text" name="name" required>
        </p>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
    <a href="Welcome.jsp">
        <button>回到首页</button>
    </a>
</div>
</body>
</html>
