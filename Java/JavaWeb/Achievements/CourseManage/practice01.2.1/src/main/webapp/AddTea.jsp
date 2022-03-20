<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/11/27
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/admin.do?method=addTea" method="post">
        <p>工号：
            <input type="text" name="tid" maxlength="8" oninput="value=value.replace(/[^\d]/g,'')">
        </p>
        <p>姓名：
            <input type="text" name="tname" maxlength="30">
        </p>
        <p>性别：
            <input type="radio" name="tgender" value="男">男
            <input type="radio" name="tgender" value="女">女
        </p>
        <p>所在学院：
            <input type="text" name="tcollege" maxlength="30">
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
    <a href="admin.jsp">
        <button>回到首页</button>
    </a>
</div>

</body>
</html>
