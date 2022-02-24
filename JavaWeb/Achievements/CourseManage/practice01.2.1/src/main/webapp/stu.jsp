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
    <title>学生首页</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/UpdateStu.jsp" method="post">
        <input type="submit" value="修改个人信息">
    </form>
    <form action="${pageContext.request.contextPath}/stu.do?method=showAllLs" method="post">
        <input type="submit" value="浏览课程信息">
    </form>
    <form action="${pageContext.request.contextPath}/stu.do?method=selectLs" method="post">
        <input type="submit" value="选课">
    </form>
    <form action="${pageContext.request.contextPath}/logout.do" method="post">
        <input type="submit" value="退出系统">
    </form>
</div>

</body>
</html>
