<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息登记</title>
    <script charset="UTF-8" type="text/javascript" src="modify.js"></script>
</head>

<body>

<div>
    <form action="${pageContext.request.contextPath}/do?method=add" method="post">
        <p>户别：
            <input type="radio" name="houseType" value="家庭户">家庭户
            <input type="radio" name="houseType" value="集体户">集体户
        </p>
        <p>住房类型：
            <input type="radio" name="homeType" value="家庭住宅">家庭住宅
            <input type="radio" name="homeType" value="集体住所">集体住所
            <input type="radio" name="homeType" value="工作地住所">工作地住所
            <input type="radio" name="homeType" value="其他住宅">其他住宅
            <input type="radio" name="homeType" value="无住宅">无住宅
        </p>
        <p>本户现住房面积：
            <input type="text" name="area" value="0" oninput="value=value.replace(/[^\d]/g,'')">
        </p>
        <p>本户现住房间数：
            <input type="text" name="roomNum" value="0" oninput="value=value.replace(/[^\d]/g,'')">
        </p>
        <p>户主姓名：
            <input type="text" name="name" required maxlength="50">
        </p>
        <p>身份证号：
            <input type="text" name="id" id="id" required onchange="checkId()">
        </p>
        <p>性别：
            <input type="radio" name="gender" value="男" required>男
            <input type="radio" name="gender" value="女" required>女
        </p>
        <p>民族：
            <input type="text" name="nation" required maxlength="50">
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
        <p>
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </p>
    </form>
    <a href="Welcome.jsp">
        <button>回到首页</button>
    </a>
</div>


</body>
</html>
