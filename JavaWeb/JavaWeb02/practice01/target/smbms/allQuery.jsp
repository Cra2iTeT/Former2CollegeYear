<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示</title>
    <style>
        table, table tr th, table tr td {
            border: 1px solid #0094ff;
        }

        .table1 {
            position: absolute;
            margin: auto;
            left: 400px;
            width: 400px;
            min-height: 30px;
            line-height: 30px;
            text-align: center;
            padding: 2px;

        }

        .pattern1 {
            position: relative;
            top: 45px;
            left: 400px;
        }
    </style>
</head>

<style>
    body{
        background-image: url("bg.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>

<body style="margin-left: 40%;margin-top: 10%;margin-right: 40%">
<div style="text-align: center">
    <table class="table1">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>班级</th>
            <th>性别</th>
            <th>功能</th>
        </tr>
        <c:forEach var="stu" items="${stuList}" varStatus="status">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.classname}</td>
                <td>${stu.gender}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/update.do?method=delete&id=${stu.id}"
                          method="post">
                        <input type="submit" value="删除">
                    </form>
                    <form action="${pageContext.request.contextPath}/update.do?method=update&id=${stu.id}"
                          method="post">
                        <input type="submit" value="修改">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="pattern1">
    <form action="${pageContext.request.contextPath}/Welcome.jsp">
        <input type="submit" value="回到首页">
    </form>
    <form action="${pageContext.request.contextPath}/update.do?method=allQuery" method="post">
        <select name="MySelect">
            <option value="idASC">学号升序</option>
            <option value="idDESC">学号降序</option>
            <option value="classnameASC">班级升序</option>
            <option value="classnameDESC">班级降序</option>
        </select>
        <input type="submit" value="确定">
    </form>
    <form action="${pageContext.request.contextPath}/add.jsp" method="post">
        <input type="submit" value="添加">
    </form>
</div>

</body>
</html>
