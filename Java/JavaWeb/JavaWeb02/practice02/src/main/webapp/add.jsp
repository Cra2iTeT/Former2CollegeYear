<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <script charset="UTF-8" type="text/javascript" src="modify.js"></script>
</head>

<style>
    body {
        background-image: url("bg.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>

<body style="margin-left: 40%;margin-top: 10%;margin-right: 40%">

<%--用a标签--%>
<div style="text-align: center;height: 500px">
    <form action="${pageContext.request.contextPath}/update.do?method=add" method="post">
        <p>学号：<input type="text" name="id" id="id" required oninput="value=value.replace(/[^\d]/g,'')" onchange="check1()"></p>
        <p>姓名：<input type="text" name="name" required maxlength="30"></p>
        <p>学生类别：
            <input type="radio" value="本科生" name="grade">本科生
            <input type="radio" value="研究生" name="grade">研究生
        </p>
        <p>院系：
            <select name="academy">
                <option value="土木学院">土木学院</option>
                <option value="机械学院">机械学院</option>
                <option value="交通学院">交通学院</option>
                <option value="信息学院">信息学院</option>
                <option value="经管学院">经管学院</option>
            </select>
        </p>
        <p>联系电话：<input type="text" name="phone" id="phone" required oninput="value=value.replace(/[^\d]/g,'')" maxlength="11" onchange="check2()"></p>
        <p>健康码颜色：
            <input type="radio" value="绿码" name="color">绿码
            <input type="radio" value="黄码" name="color">黄码
            <input type="radio" value="红码" name="color">红码
        </p>
        <p>行程统计：
            <input type="checkbox" value="1" name="position">10月30日去过人民医院
            <input type="checkbox" value="2" name="position">10月25日以来去过深泽县人民医院
            <input type="checkbox" value="3" name="position">10月16日以来去过深泽县庄泽村
            <input type="checkbox" value="4" name="position">10月29日以来去过黑龙江哈尔滨市或黑河市
            <input type="checkbox" value="5" name="position">10月18日以来途径贵州遵义市、北京丰台、昌平
            <input type="checkbox" value="6" name="position">10月17日以来到过湖南长沙、青海海东市
        </p>
        <p>其他涉疫信息需要填报的：
            <input type="text" name="other" maxlength="100">
        </p>

        <p>
            <input type="submit">
            <input type="reset">
        </p>
    </form>
</div>


</body>
</html>
