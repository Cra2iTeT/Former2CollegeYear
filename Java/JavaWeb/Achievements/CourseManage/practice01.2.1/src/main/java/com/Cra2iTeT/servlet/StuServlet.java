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

public class StuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if (method.equals("updateStu")) {
            if (this.updateStu(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"学生信息修改成功\");window.location='stu.jsp'</script>");
            }
            resp.getWriter().print("<script> alert(\"学生信息修改失败，请与管理员联系\");window.location='stu.jsp'</script>");
        } else if (method.equals("showAllLs")) {//查看所有课程
            List<Ls> list = this.showAllLs(req, resp);
            if (list.size() == 0) {
                resp.getWriter().print("<script> alert(\"课程查询结果为空\");window.location='stu.jsp'</script>");
            }
            req.getSession().setAttribute("lsSession", list);//登录周期内有效
            req.getRequestDispatcher("ShowAllLs.jsp").forward(req, resp);
        } else if (method.equals("cheekLs")) {//查看课程详细信息
            Ls ls = this.cheekLs(req, resp);
            req.setAttribute("ls", ls);
            req.getRequestDispatcher("CheekLs.jsp").forward(req, resp);
        } else if (method.equals("cheekTea")) {//查看老师信息
            Tea tea = this.cheekTea(req, resp);
            req.setAttribute("tea", tea);
            req.getRequestDispatcher("CheekTea.jsp").forward(req, resp);
        } else if (method.equals("selectLs")) {//查看可选课程
            List<Ls> list = this.selectLs(req, resp);
            if (list.size() == 0) {
                resp.getWriter().print("<script> alert(\"所有课程全满，请与教师联系\");window.location='stu.jsp'</script>");
            }
            req.getSession().setAttribute("selectLsSession", list);
            req.getRequestDispatcher("SelectLs.jsp").forward(req, resp);
        } else if (method.equals("cheek")) {//展开要选的课程信息
            Ls ls = this.cheekLs(req, resp);
            req.setAttribute("ls", ls);
            req.getRequestDispatcher("Select.jsp").forward(req, resp);
        } else if (method.equals("select")) {//选课
            int temp = this.select(req, resp);
            if (temp > 0) {
                resp.getWriter().print("<script> alert(\"选课成功\");window.location='stu.jsp'</script>");
            } else if (temp == -1)
                resp.getWriter().print("<script> alert(\"选课失败,已经选过该课程\");window.location='stu.jsp'</script>");
            else
                resp.getWriter().print("<script> alert(\"选课失败,请与管理员联系\");window.location='stu.jsp'</script>");
        }
    }

    public int updateStu(HttpServletRequest req, HttpServletResponse resp) {
        Stu stu = new Stu();
        stu.setSid((int) req.getSession().getAttribute("userSession"));//从session中获得学号
        stu.setSname(req.getParameter("sname"));
        stu.setSgender(req.getParameter("sgender"));
        stu.setSclass(req.getParameter("sclass"));
        stu.setSmajor(req.getParameter("smajor"));

        List<Object> list = new ArrayList<>();

        list.add(stu.getSname());
        list.add(stu.getSgender());
        list.add(stu.getSclass());
        list.add(stu.getSmajor());
        list.add(stu.getSid());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "update stu set sname = ?,sgender = ?,sclass = ?,smajor = ? where sid = ?";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public List<Ls> showAllLs(HttpServletRequest req, HttpServletResponse resp) {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Ls> list = new ArrayList<>();

        String sql = "select * from ls";
        rs = BaseDao.executeQuery(connection, pstm, rs, sql, null);

        try {
            while (rs.next()) {
                Ls _ls = new Ls();
                _ls.setLid(rs.getInt("lid"));
                _ls.setLname(rs.getString("lname"));
                _ls.setTid(rs.getInt("tid"));
                _ls.setLnum(rs.getString("lnum"));
                _ls.setLsum(rs.getString("lsum"));
                _ls.setTname(rs.getString("tname"));
                list.add(_ls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(connection, pstm, rs);
        return list;
    }

    public Ls cheekLs(HttpServletRequest req, HttpServletResponse resp) {
        List<Object> list = new ArrayList<>();
        list.add(req.getParameter("lid"));
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "select * from ls where lid = ?";
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());

        Ls ls = new Ls();
        try {
            if (rs.next()) {
                ls.setLid(Integer.parseInt(req.getParameter("lid")));
                ls.setLname(rs.getString("lname"));
                ls.setTid(rs.getInt("tid"));
                ls.setLnum(rs.getString("lnum"));
                ls.setLsum(rs.getString("lsum"));
                ls.setTname(rs.getString("tname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return ls;
    }

    public Tea cheekTea(HttpServletRequest req, HttpServletResponse resp) {
        List<Object> list = new ArrayList<>();
        list.add(req.getParameter("tid"));
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Tea tea = new Tea();

        String sql = "select * from tea where tid = ?";
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());
        try {
            if (rs.next()) {
                tea.setTid(Integer.parseInt(req.getParameter("tid")));
                tea.setTname(rs.getString("tname"));
                tea.setTgender(rs.getString("tgender"));
                tea.setTcollege(rs.getString("tcollege"));
                tea.setTtitle(rs.getString("ttitle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return tea;
    }

    public List<Ls> selectLs(HttpServletRequest req, HttpServletResponse resp) {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Ls> list = new ArrayList<>();

        String sql = "select * from ls";
        rs = BaseDao.executeQuery(connection, pstm, rs, sql, null);

        try {
            while (rs.next()) {
                Ls _ls = new Ls();
                _ls.setLid(rs.getInt("lid"));
                _ls.setLname(rs.getString("lname"));
                _ls.setTid(rs.getInt("tid"));
                _ls.setLnum(rs.getString("lnum"));
                int num = Integer.parseInt(_ls.getLnum());
                _ls.setLsum(rs.getString("lsum"));
                int sum = Integer.parseInt(_ls.getLsum());
                _ls.setTname(rs.getString("tname"));

                if (sum < num) {//选课人数未达上限
                    list.add(_ls);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(connection, pstm, rs);
        return list;
    }

    public int select(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        List<Object> list = new ArrayList<>();
        list.add(req.getParameter("lid"));
        list.add(req.getSession().getAttribute("userSession"));
        String sql = "select * from cm where cmlid = ? and cmsid = ?";
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());
        try {
            if (rs.next()) {//已经选过该课程
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);

        conn = BaseDao.getConnection();
        pstm = null;
        list.add(req.getParameter("tid"));
        sql = "insert into cm (`cmlid`,`cmsid`,`cmtid`) values(?,?,?)";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());//修改选课表数据
        BaseDao.removeConnection(conn, pstm, null);
        if (temp > 0) {
            list.removeAll(list);//清空
            int lsum = Integer.parseInt(req.getParameter("lsum")) + 1;//修改选课人数
            list.add(lsum);
            list.add(req.getParameter("lid"));
            conn = BaseDao.getConnection();
            pstm = null;
            sql = "update ls set lsum = ? where lid = ?";
            //System.out.println(temp+"===========");
            temp = BaseDao.execute(conn, pstm, sql, list.toArray());
            //System.out.println(temp+"===========");
        }
        //System.out.println(temp+"===========");
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }
}
