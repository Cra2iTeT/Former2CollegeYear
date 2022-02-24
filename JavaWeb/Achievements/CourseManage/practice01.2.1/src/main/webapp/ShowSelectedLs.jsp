<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程列表</title>
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
        </tr>
        <c:forEach var="selectedLs" items="${selectedLs}" varStatus="status">
            <tr>
                <td>${selectedLs.tid}</td>
                <td><a href="${pageContext.request.contextPath}/tea.do?method=showSelectedStu&lid=${selectedLs.lid}">${selectedLs.lname}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="pattern1">
    <form action="${pageContext.request.contextPath}/tea.jsp">
        <input type="submit" value="回到首页">
    </form>
</div>
</body>
</html>