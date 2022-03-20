<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/10/16
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>if测试</h4>
<hr>
<form action="jsp4.jsp" method="get">
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="提交">
</form>

<c:if test="${param.username=='admin' }" var="isAdmin">
    <c:out value="管理员欢迎您！"/>
</c:if>

<c:out value="${isAdmin}"/>
</body>
</html>
