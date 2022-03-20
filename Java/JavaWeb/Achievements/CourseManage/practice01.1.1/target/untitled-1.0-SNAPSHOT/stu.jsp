<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/11/26
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/do?method=updateStu0&sid=${requestScope.id}" method="post">
        <input type="submit" value="修改个人信息">
    </form>
    <form action="${pageContext.request.contextPath}/do?method=showCl&sid=${requestScope.id}" method="post">
        <input type="submit" value="浏览课程信息">
    </form>
</div>

</body>
</html>
