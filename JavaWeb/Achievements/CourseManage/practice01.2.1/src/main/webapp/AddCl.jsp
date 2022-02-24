<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
</head>

<body>

<div>
    <form action="${pageContext.request.contextPath}/tea.do?method=addCl" method="post">
        <p>课程编号：
            <input type="text" name="lid" maxlength="6" oninput="value=value.replace(/[^\d]/g,'')">
        </p>
        <p>课程名称：
            <input type="text" name="lname" maxlength="30">
        </p>
        <p>选课容量：
            <input type="text" name="lnum" maxlength="5">
        </p>
        <p>任课教师编号：${userSession}</p>
        <p>
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </p>
    </form>
    <form action="${pageContext.request.contextPath}/tea.jsp" method="post">
        <input type="submit" value="返回上一页">
    </form>
</div>


</body>
</html>
