<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/11/26
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/do?method=login" method="post">
        <p>账号：
            <input type="text" name="id">
        </p>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
