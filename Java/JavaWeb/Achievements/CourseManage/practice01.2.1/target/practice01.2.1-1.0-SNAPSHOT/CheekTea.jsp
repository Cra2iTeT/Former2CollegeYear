<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息</title>
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
            <td>${tea.tid}</td>
            <td>${tea.tname}</td>
            <td>${tea.tgender}</td>
            <td>${tea.tcollege}</td>
            <td>${tea.ttitle}</td>
        </tr>
    </table>
</div>
<div class="pattern1">
    <form action="${pageContext.request.contextPath}/stu.jsp">
        <input type="submit" value="回到首页">
    </form>
</div>
</body>
</html>
