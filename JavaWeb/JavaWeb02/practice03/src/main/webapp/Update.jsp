<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/11/5
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息修改</title>
    <script type="text/javascript" charset="UTF-8" src="modify.js"></script>
</head>
<body>

<div>
    <form action="${pageContext.request.contextPath}/update.do?method=update1&name=${requestScope.name}" method="post">
        <p>身份证号码：
            <input type="text" name="id" id="id" onchange="checkId()">
        </p>
        <p>性别：
            <input type="radio" name="gender" value="男">男
            <input type="radio" name="gender" value="女">女
        </p>
        <p>民族：
            <input type="text" name="nation" maxlength="50">
        </p>
        <p>受教育程度:
            <select name="edu">
                <option value="研究生">研究生</option>
                <option value="大学本科">大学本科</option>
                <option value="大学专科">大学专科</option>
                <option value="高中">高中</option>
                <option value="初中">初中</option>
                <option value="小学">小学</option>
                <option value="未上学">未上学</option>
            </select>
        </p>
    </form>
</div>
</body>
</html>
