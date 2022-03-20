package com.Cra2iTeT.servlet;

import com.Cra2iTeT.dao.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if (method.equals("addTea")) {//添加教师
            if (this.AddTea(req, resp, 1) > 0) {
                resp.getWriter().print("<script> alert(\"教师添加成功\");window.location='admin.jsp'</script>");
            }
            resp.getWriter().print("<script> alert(\"教师添加失败\");window.location='admin.jsp'</script>");
        } else if (method.equals("addStu")) {//添加学生
            if (this.AddTea(req, resp, 2) > 0) {
                resp.getWriter().print("<script> alert(\"学生添加成功\");window.location='admin.jsp'</script>");
            }
            resp.getWriter().print("<script> alert(\"学生添加失败\");window.location='admin.jsp'</script>");
        }
    }

    public int AddTea(HttpServletRequest req, HttpServletResponse resp, int i) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql;
        List<Object> list = new ArrayList<>();

        if (i == 1) {
            sql = "insert into tea (`tid`,`tname`,`tgender`,`tcollege`,`ttitle`) values (?,?,?,?,?)";
            list.add(req.getParameter("tid"));
            list.add(req.getParameter("tname"));
            list.add(req.getParameter("tgender"));
            list.add(req.getParameter("tcollege"));
            list.add(req.getParameter("ttitle"));
        } else {
            sql = "insert into stu (`sid`,`sname`,`sgender`,`sclass`,`smajor`) values (?,?,?,?,?)";
            list.add(req.getParameter("sid"));
            list.add(req.getParameter("sname"));
            list.add(req.getParameter("sgender"));
            list.add(req.getParameter("sclass"));
            list.add(req.getParameter("smajor"));
        }
        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

}
