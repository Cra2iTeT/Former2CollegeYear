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
    </style>
</head>


<body style="margin-left: 40%;margin-top: 10%;margin-right: 40%">
<div style="text-align: center">
    <table class="table1">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>所在班级</th>
            <th>所属专业</th>
        </tr>
        <c:forEach var="stulist" items="${stulist}" varStatus="status">
            <tr>
                <td>${stulist.id}</td>
                <td>${stulist.name}</td>
                <td>${stulist.gender}</td>
                <td>${stulist.cl}</td>
                <td>${stulist.major}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
