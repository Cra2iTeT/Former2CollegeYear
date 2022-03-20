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
            <th>姓名</th>
            <th>性别</th>
            <th>民族</th>
            <th>受教育程度</th>
        </tr>
        <c:forEach var="personList" items="${personList}" varStatus="status">
            <tr>
                <td><a href="${pageContext.request.contextPath}/do?method=show&name=${personList.name}">${personList.name}</a></td>
                <td>${personList.gender}</td>
                <td>${personList.nation}</td>
                <td>${personList.edu}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
