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
            <th>课程编号</th>
            <th>课程名称</th>
            <th>任课教师</th>
            <th>选课人数</th>
        </tr>
        <tr>
            <td>${cl.id}</td>
            <td>${cl.name}</td>
            <td><a href="${pageContext.request.contextPath}/do?method=scanTea&tid=${cl.tid}">${cl.tname}</a></td>
            <td>${cl.num}</td>
            <td>
                <form action="${pageContext.request.contextPath}/do?method=chooseCl&cid=${cl.id}&sid=${requestScope.sid}"
                      method="post">
                    <input type="submit" value="选择">
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
