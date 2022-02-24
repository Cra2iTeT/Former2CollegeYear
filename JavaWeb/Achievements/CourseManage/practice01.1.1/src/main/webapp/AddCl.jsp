<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息登记</title>
</head>

<body>

<div>
    <form action="${pageContext.request.contextPath}/do?method=addCl&tid=${requestScope.tid}" method="post">
        <p>课程编号：
            <input type="text" name="cid" maxlength="6" oninput="value=value.replace(/[^\d]/g,'')">
        </p>
        <p>课程名称：
            <input type="text" name="cname" maxlength="30">
        </p>
        <p>选课人数：
            <input type="text" name="num">
        </p>
        <p>任课教师编号：${requestScope.tid}</p>
        <p>
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </p>
    </form>
</div>


</body>
</html>
