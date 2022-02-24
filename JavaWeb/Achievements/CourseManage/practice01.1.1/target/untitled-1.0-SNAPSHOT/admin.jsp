<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/11/26
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/AddTea.jsp" method="post">
        <input type="submit" value="添加教师信息">
    </form>
    <form action="${pageContext.request.contextPath}/AddStu.jsp" method="post">
        <input type="submit" value="添加学生信息">
    </form>
</div>
</body>
</html>
