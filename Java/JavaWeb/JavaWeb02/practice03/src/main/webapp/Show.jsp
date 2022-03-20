<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/11/9
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
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
            <th>户别</th>
            <th>住房类型</th>
            <th>本户现住房面积</th>
            <th>本户现住房间数</th>
            <th>姓名</th>
            <th>身份证号码</th>
            <th>性别</th>
            <th>民族</th>
            <th>受教育程度</th>
        </tr>
        <c:forEach var="personList" items="${personList}" varStatus="status">
            <tr>
                <td>${personList.houseType}</td>
                <td>${personList.homeType}</td>
                <td>${personList.area}</td>
                <td>${personList.roomNum}</td>
                <td>${personList.name}</td>
                <td>${personList.id}</td>
                <td>${personList.gender}</td>
                <td>${personList.nation}</td>
                <td>${personList.edu}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>