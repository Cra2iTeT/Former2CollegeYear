<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息</title>
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
            <th>课程编号</th>
            <th>课程名称</th>
            <th>任课教师</th>
            <th>选课人数</th>
            <th>课程容量</th>
            <th>功能</th>
        </tr>
        <tr>
            <td>${ls.lid}</td>
            <td>${ls.lname}</td>
            <td>${ls.tname}</td>
            <td>${ls.lsum}</td>
            <td>${ls.lnum}</td>
            <td>
                <form action="${pageContext.request.contextPath}/stu.do?method=select&lid=${ls.lid}&tid=${ls.tid}&lsum=${ls.lsum}" method="post">
                    <p>
                        <input type="submit" value="选择">
                    </p>
                </form>
            </td>
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

