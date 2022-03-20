<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息修改</title>
</head>

<body>

<div>
    <form action="${pageContext.request.contextPath}/stu.do?method=updateStu" method="post">
<%--        <P>学号：--%>
<%--            <input type="text" name="sid" maxlength="8" oninput="value=value.replace(/[^\d]/g,'')">--%>
<%--        </P>--%>
        <p>姓名：
            <input type="text" name="sname" maxlength="30">
        </p>
        <p>性别：
            <input type="radio" name="sgender" value="男">男
            <input type="radio" name="sgender" value="女">女
        </p>
        <p>所在班级：
            <input type="text" name="sclass">
        </p>
        <p>所属专业：
            <input type="text" name="smajor">
        </p>
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

