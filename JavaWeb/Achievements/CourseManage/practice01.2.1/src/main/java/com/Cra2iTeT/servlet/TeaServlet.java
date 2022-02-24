package com.Cra2iTeT.servlet;

import com.Cra2iTeT.dao.BaseDao;
import com.Cra2iTeT.pojo.Ls;
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

public class TeaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if (method.equals("updateTea")) {
            if (this.updateTea(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"教师信息修改成功\");window.location='tea.jsp'</script>");
            }
            resp.getWriter().print("<script> alert(\"教师信息修改失败，请与管理员联系\");window.location='tea.jsp'</script>");
        } else if (method.equals("addCl")) {
            if (this.addLs(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"课程添加成功\");window.location='tea.jsp'</script>");
            }
            resp.getWriter().print("<script> alert(\"课程添加失败，请与管理员联系\");window.location='tea.jsp'</script>");
        } else if (method.equals("showSelectedStu")) {
            List<Stu> list = this.showSelectedStu(req, resp);
            //System.out.println(list.size());
            if (list.size() != 0) {
                req.getSession().setAttribute("selectedStu", list);
                req.getRequestDispatcher("ShowSelectedStu.jsp").forward(req, resp);
            }
            resp.getWriter().print("<script> alert(\"未查询到选择该课程的学生，如有疑问请与管理员联系\");window.location='tea.jsp'</script>");
        } else if (method.equals("showSelectedLs")) {//查看教授的课程
            List<Ls> list = this.showSelectedLs(req, resp);
            if (list.size() == 0) {
                resp.getWriter().print("<script> alert(\"未查询到你教授的课程，如有疑问请与管理员联系\");window.location='tea.jsp'</script>");
            }
            req.getSession().setAttribute("selectedLs", list);
            req.getRequestDispatcher("ShowSelectedLs.jsp").forward(req, resp);
        }
    }

    public int updateTea(HttpServletRequest req, HttpServletResponse resp) {
        Tea tea = new Tea();
        tea.setTid((int) req.getSession().getAttribute("userSession"));//从session中获得工号
        tea.setTname(req.getParameter("tname"));
        tea.setTgender(req.getParameter("tgender"));
        tea.setTcollege(req.getParameter("tcollege"));
        tea.setTtitle(req.getParameter("ttitle"));

        List<Object> list = new ArrayList<>();

        list.add(tea.getTname());
        list.add(tea.getTgender());
        list.add(tea.getTcollege());
        list.add(tea.getTtitle());
        list.add(tea.getTid());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "update tea set tname = ?,tgender = ?,tcollege = ?,ttitle = ? where tid = ?";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        sql = "update ls set tname = ? where tid = ?";//课程表数据修改
        for (int i = 4; i > 0; i--) {
            list.remove(i);//清除
        }
        list.add(req.getSession().getAttribute("userSession"));
        BaseDao.execute(conn, pstm, sql, list.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public int addLs(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        List<Object> list = new ArrayList<>();

        list.add(req.getParameter("lid"));
        list.add(req.getParameter("lname"));
        list.add(req.getSession().getAttribute("userSession"));
        list.add(req.getParameter("lnum"));
        list.add(req.getSession().getAttribute("tname"));
        list.add(0);

        String sql = "insert into ls (`lid`,`lname`,`tid`,`lnum`,`tname`,`lsum`) values(?,?,?,?,?,?)";
        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public List<Stu> showSelectedStu(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Object> list = new ArrayList<>();

        list.add(req.getSession().getAttribute("userSession"));
        list.add(req.getParameter("lid"));

        String sql = "select * from cm where cmtid = ? and cmlid = ?";
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());
        list.removeAll(list);

        List<Stu> stuList = new ArrayList<>();
        //BaseDao.removeConnection(conn, pstm, null);

        try {
            while (rs.next()) {
                ResultSet rs1 = null;
                sql = "select * from stu where sid = ?";
                list.add(rs.getInt("cmsid"));
                conn = BaseDao.getConnection();
                pstm = null;
                rs1 = BaseDao.executeQuery(conn, pstm, rs1, sql, list.toArray());
                list.removeAll(list);
                Stu stu = new Stu();
                if (rs1.next()) {
                    stu.setSid(rs1.getInt("sid"));
                    stu.setSname(rs1.getString("sname"));
                    stu.setSgender(rs1.getString("sgender"));
                    stu.setSclass(rs1.getString("sclass"));
                    stu.setSmajor(rs1.getString("smajor"));
                }
                stuList.add(stu);
                //BaseDao.removeConnection(conn, pstm, rs1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(null, null, rs);
        //System.out.println(stuList.size());
        return stuList;
    }

    public List<Ls> showSelectedLs(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Object> list = new ArrayList<>();
        list.add(req.getSession().getAttribute("userSession"));

        String sql = "select * from ls where tid = ?";
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());

        List<Ls> lsList = new ArrayList<>();
        try {
            while (rs.next()) {
                Ls ls = new Ls();
                ls.setLid(rs.getInt("lid"));
                ls.setLname(rs.getString("lname"));
                ls.setTid(rs.getInt("tid"));
                ls.setTname(rs.getString("tname"));
                ls.setLnum(rs.getString("lnum"));
                ls.setLsum(rs.getString("lsum"));
                lsList.add(ls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return lsList;
    }
}
