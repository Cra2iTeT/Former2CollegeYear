<%--
  Created by IntelliJ IDEA.
  User: zeroVo
  Date: 2021/10/15
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%@page import="lesson.ClassDaoImpl" %>
<%@page import="lesson.HaveClass" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    //接收客户端传递过来的参数

    String teachername = request.getParameter("teachername");
    String classname = request.getParameter("classname");
    String place = request.getParameter("place");
    try {
        if (!teachername.trim().equals("王建民") && !teachername.trim().equals("刘立嘉") && !teachername.trim().equals("刘丹") && !teachername.trim().equals("王辉") && !teachername.trim().equals("杨子光")) {
            System.out.println("不能输入规定之外的老师名称");
        } else if (!place.trim().startsWith("基教") && !place.trim().startsWith("一教") && !place.trim().startsWith("二教") && !place.trim().startsWith("三教")) {
            System.out.println("不能输入规定之外的地点名称！");
        } else {
            HaveClass haveclass = new HaveClass();
            haveclass.setTeachername(teachername);
            haveclass.setClassname(classname);
            haveclass.setPlace(place);
            ClassDaoImpl classDao = new ClassDaoImpl();
            classDao.add(haveclass);
        }

    } catch (Exception e) {

%>
<h2 style="color:red ; font-size:50px">发生错误 : <%=e.getMessage() %>
</h2>
<%
    }


%>


</html>
