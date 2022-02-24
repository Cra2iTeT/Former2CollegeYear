package com.Cra2iTeT.servlet;

import com.Cra2iTeT.dao.BaseDao;
import com.Cra2iTeT.pojo.Stu;
import com.Cra2iTeT.pojo.Tea;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet===========");

        //获取用户账号
        int code = Integer.parseInt(req.getParameter("code"));
        String role = req.getParameter("role");

        if (role.equals("管理员") && code == 123456) {
            req.getSession().setAttribute("userSession", code);
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        } else if (role.equals("教师")) {
            Object o = this.selectById(code, 1);
            if (!o.equals(false)) {
                req.getSession().setAttribute("userSession", code);
                req.getSession().setAttribute("tname", ((Tea) o).getTname());
                req.getRequestDispatcher("tea.jsp").forward(req, resp);
            }
        } else if (role.equals("学生")) {
            Object o = this.selectById(code, 2);
            if (!o.equals(false)) {
                System.out.println("==================");
                req.getSession().setAttribute("userSession", code);
                req.getSession().setAttribute("sname", ((Stu) o).getSname());
                req.getRequestDispatcher("stu.jsp").forward(req, resp);
            }
        }
        resp.getWriter().print("<script> alert(\"账号错误\"); window.location='Login.jsp'</script>");
    }

    public Object selectById(int id, int i) {//搜索用户
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql;
        if (i == 1) {
            sql = "select * from tea where tid = ?";
        } else {
            sql = "select * from stu where sid = ?";
        }

        List<Object> list = new ArrayList<>();
        list.add(id);

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());

        try {
            if (rs.next()) {
                if (i == 1) {
                    Tea tea = new Tea();
                    tea.setTtitle(rs.getString("ttitle"));
                    tea.setTid(id);
                    tea.setTgender(rs.getString("tgender"));
                    tea.setTcollege(rs.getString("tcollege"));
                    tea.setTname(rs.getString("tname"));
                    BaseDao.removeConnection(conn, pstm, rs);
                    return tea;
                } else if (i == 2) {
                    Stu stu = new Stu();
                    stu.setSmajor(rs.getString("smajor"));
                    stu.setSid(id);
                    stu.setSgender(rs.getString("sgender"));
                    stu.setSname(rs.getString("sname"));
                    stu.setSclass(rs.getString("sclass"));
                    BaseDao.removeConnection(conn, pstm, rs);
                    return stu;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return false;
    }
}
