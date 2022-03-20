<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息修改</title>
</head>

<body>

<div>
    <form action="${pageContext.request.contextPath}/tea.do?method=updateTea" method="post">
        <%--        <P>学号：--%>
        <%--            <input type="text" name="sid" maxlength="8" oninput="value=value.replace(/[^\d]/g,'')">--%>
        <%--        </P>--%>
        <p>姓名：
            <input type="text" name="tname" maxlength="30">
        </p>
        <p>性别：
            <input type="radio" name="tgender" value="男">男
            <input type="radio" name="tgender" value="女">女
        </p>
        <p>所在学院：
            <input type="text" name="tcollege">
        </p>
        <p>职称：
            <input type="radio" name="ttitle" value="教授">教授
            <input type="radio" name="ttitle" value="副教授">副教授
            <input type="radio" name="ttitle" value="讲师">讲师
            <input type="radio" name="ttitle" value="助教">助教
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
