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
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>所在学院</th>
            <th>职称</th>
        </tr>
        <tr>
            <td>${tea.id}</td>
            <td>${tea.name}</td>
            <td>${tea.gender}</td>
            <td>${tea.college}</td>
            <td>${tea.cl}</td>
        </tr>
    </table>
</div>
</body>
</html>
