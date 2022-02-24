<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    
%>

<jsp:useBean id="person" class="Person" scope="page"/>
<jsp:setProperty name="person" property="address" value="河北"/>
<jsp:setProperty name="person" property="id" value="1"/>
<jsp:setProperty name="person" property="name" value="Cra2iTeT"/>
<jsp:setProperty name="person" property="age" value="3"/>

姓名：<jsp:getProperty name="person" property="name"/>
ID：<jsp:getProperty name="person" property="id"/>
年龄：<jsp:getProperty name="person" property="age"/>
地址：<jsp:getProperty name="person" property="address"/>
</body>
</html>
