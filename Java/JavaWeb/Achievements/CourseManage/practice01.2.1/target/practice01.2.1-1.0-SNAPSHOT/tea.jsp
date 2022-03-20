<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/11/26
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师首页</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/UpdateTea.jsp" method="post">
        <input type="submit" value="修改个人信息">
    </form>
    <form action="${pageContext.request.contextPath}/AddCl.jsp" method="post">
        <input type="submit" value="添加课程">
    </form>
    <form action="${pageContext.request.contextPath}/tea.do?method=showSelectedLs" method="post">
        <input type="submit" value="浏览选课学生信息">
    </form>
    <form action="${pageContext.request.contextPath}/logout.do" method="post">
        <input type="submit" value="退出系统">
    </form>
</div>

</body>
</html>
