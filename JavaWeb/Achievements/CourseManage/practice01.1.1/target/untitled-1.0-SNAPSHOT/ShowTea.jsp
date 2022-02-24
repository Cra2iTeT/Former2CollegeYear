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
            <th>课程编号</th>
            <th>课程名称</th>
        </tr>
        <c:forEach var="cl" items="${cl}" varStatus="status">
            <tr>
                <td>${cl.id}</td>
                <td><a href="${pageContext.request.contextPath}/do?method=showStu&cid=${cl.id}">${cl.name}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
