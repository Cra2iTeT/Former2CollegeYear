<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/11/5
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息删除</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/do?method=delete" method="post">
        <p>户主姓名：
            <input type="text" name="name" required>
        </p>
        <input type="submit" value="删除">
        <input type="reset" value="重置">
    </form>
    <a href="Welcome.jsp">
        <button>回到首页</button>
    </a>
</div>

</body>
</html>
