package com.Cra2iTeT.servlet;

import com.Cra2iTeT.dao.BaseDao;
import com.Cra2iTeT.bean.Cl;
import com.Cra2iTeT.bean.Student;
import com.Cra2iTeT.bean.Teacher;

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

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");
        if (method.equals("addStu")) {
            if (this.addStu(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"添加成功\");window.location='admin.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"添加失败\");window.location='admin.jsp'</script>");
            }
        } else if (method.equals("addTea")) {
            if (this.addTea(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"添加成功\");window.location='admin.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"添加失败\");window.location='admin.jsp'</script>");
            }
        } else if (method.equals("addCl")) {
            if (this.addCl(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"添加成功\");window.location='tea.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"添加失败\");window.location='tea.jsp'</script>");
            }
        } else if (method.equals("updateStu0")) {
            req.setAttribute("sid", req.getParameter("sid"));
            //System.out.println(req.getParameter("sid"));
            req.getRequestDispatcher("UpdateStu.jsp").forward(req, resp);
        } else if (method.equals("updateStu")) {
            System.out.println("sid:"+req.getParameter("sid"));
            System.out.println("id:"+req.getParameter("id"));
            req.setAttribute("sid", req.getParameter("sid"));
            if (this.updateStu(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"修改成功\");window.location='stu.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"修改失败\");window.location='stu.jsp'</script>");
            }
        } else if (method.equals("updateTea0")) {
            req.setAttribute("tid", req.getParameter("tid"));
            req.getRequestDispatcher("UpdateTea.jsp").forward(req, resp);
        } else if (method.equals("updateTea")) {
            req.setAttribute("tid", req.getParameter("tid"));
            if (this.updateTea(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"修改成功\");window.location='tea.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"修改失败\");window.location='tea.jsp'</script>");
            }
        } else if (method.equals("scanCl")) {
            Cl cl = (Cl) this.scanCl(req, resp);
            req.setAttribute("cl", cl);
            req.setAttribute("sid", req.getParameter("sid"));
            req.getRequestDispatcher("ScanCl.jsp").forward(req, resp);
        } else if (method.equals("scanTea")) {
            Teacher teacher = (Teacher) this.showTea(req, resp);
            req.setAttribute("tea", teacher);
            req.getRequestDispatcher("ScanTea.jsp").forward(req, resp);
        } else if (method.equals("chooseCl")) {
            if (this.chooseCl(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"选课成功\");window.location='stu.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"选课失败\");window.location='stu.jsp'</script>");
            }
        } else if (method.equals("showStu")) {
            List<Student> stulist = this.showStu(req, resp);
            if (stulist.size() == 0) {
                resp.getWriter().print("<script> alert(\"查询结果为空\"); window.location='tea.jsp'</script>");
            } else {
                req.setAttribute("stulist", stulist);
                req.getRequestDispatcher("ShowStu.jsp").forward(req, resp);
            }
        } else if (method.equals("login")) {
            int id = Integer.parseInt(req.getParameter("id"));
            if (id == 12345) {
                req.getRequestDispatcher("admin.jsp").forward(req, resp);
            } else {
                Teacher teacher = this.teaById(id);
                req.setAttribute("id", id);
                System.out.println(teacher.getId());
                if (teacher.getId() == 0) {
                    Student student = this.stuById(id);
                    if (student.getId() == 0)
                        resp.getWriter().print("<script> alert(\"账号错误\"); window.location='Welcome.jsp'</script>");
                    req.getRequestDispatcher("stu.jsp").forward(req, resp);
                }
                req.getRequestDispatcher("tea.jsp").forward(req, resp);
            }
        } else if (method.equals("showCl")) {
            List<Cl> clList = this.showCl(req, resp);
            req.setAttribute("sid", req.getParameter("sid"));
            if (clList.size() == 0) {
                resp.getWriter().print("<script> alert(\"查询结果为空\"); window.location='stu.jsp'</script>");
            } else {
                req.setAttribute("cl", clList);
                req.getRequestDispatcher("ShowCl.jsp").forward(req, resp);
            }
        } else if (method.equals("addCl0")) {
            System.out.println(req.getParameter("tid"));
            req.setAttribute("tid", req.getParameter("tid"));
            req.getRequestDispatcher("AddCl.jsp").forward(req, resp);
        } else if (method.equals("show")) {
            int tid= Integer.parseInt(req.getParameter("tid"));
            System.out.println(tid);
            List<Cl> clList = this.showStu(tid);
            if (clList.size() == 0) {
                resp.getWriter().print("<script> alert(\"查询结果为空\"); window.location='tea.jsp'</script>");
            } else {
                req.setAttribute("cl", clList);
                req.getRequestDispatcher("ShowTea.jsp").forward(req, resp);
            }
        }
    }

    public int addStu(HttpServletRequest req, HttpServletResponse resp) {
        Student stu = new Student();
        stu.setId(Integer.parseInt(req.getParameter("sid")));
        stu.setName(req.getParameter("sname"));
        stu.setGender(req.getParameter("gender"));
        stu.setCl(req.getParameter("cl"));
        stu.setMajor(req.getParameter("major"));

        List<Object> list = new ArrayList<>();

        list.add(stu.getId());
        list.add(stu.getName());
        list.add(stu.getGender());
        list.add(stu.getCl());
        list.add(stu.getMajor());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "insert into `student` (`sid`,`sname`,`gender`,`cl`,`major`) values(?,?,?,?,?)";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public int addTea(HttpServletRequest req, HttpServletResponse resp) {
        Teacher teacher = new Teacher();
        teacher.setId(Integer.parseInt(req.getParameter("tid")));
        teacher.setName(req.getParameter("tname"));
        teacher.setGender(req.getParameter("gender"));
        teacher.setCollege(req.getParameter("college"));
        teacher.setCl(req.getParameter("cl"));

        List<Object> list = new ArrayList<>();

        list.add(teacher.getId());
        list.add(teacher.getName());
        list.add(teacher.getGender());
        list.add(teacher.getCollege());
        list.add(teacher.getCl());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "insert into `teacher` (`tid`,`tname`,`gender`,`college`,`cl`) values(?,?,?,?,?)";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public int addCl(HttpServletRequest req, HttpServletResponse resp) {
        Cl cl = new Cl();
        cl.setId(Integer.parseInt(req.getParameter("cid")));
        cl.setTid(Integer.parseInt(req.getParameter("tid")));
        cl.setName(req.getParameter("cname"));
        cl.setNum(Integer.parseInt(req.getParameter("num")));

        List<Object> list = new ArrayList<>();

        list.add(cl.getId());
        list.add(cl.getTid());
        list.add(cl.getName());
        list.add(cl.getNum());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "insert into `cl` (`cid`,`tid`,`cname`,`num`) values(?,?,?,?)";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        if (temp > 0) {
            sql = "update teacher set cid = ? where tid = ?";
            List<Object> list1 = new ArrayList<>();
            list1.add(cl.getId());
            list1.add(cl.getTid());
            BaseDao.execute(conn, pstm, sql, list1.toArray());
        }
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public int updateStu(HttpServletRequest req, HttpServletResponse resp) {
        Student stu = new Student();
        stu.setId(Integer.parseInt(req.getParameter("sid")));
        stu.setName(req.getParameter("sname"));
        stu.setGender(req.getParameter("gender"));
        stu.setCl(req.getParameter("cl"));
        stu.setMajor(req.getParameter("major"));

        List<Object> list = new ArrayList<>();

        list.add(stu.getName());
        list.add(stu.getGender());
        list.add(stu.getCl());
        list.add(stu.getMajor());
        list.add(stu.getId());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "update `student` set `sname` = ?,`gender` = ?,`cl` = ?,`major` = ? where sid = ?";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public int updateTea(HttpServletRequest req, HttpServletResponse resp) {
        Teacher teacher = new Teacher();
        teacher.setId(Integer.parseInt(req.getParameter("tid")));
        teacher.setName(req.getParameter("tname"));
        teacher.setGender(req.getParameter("gender"));
        teacher.setCollege(req.getParameter("college"));
        teacher.setCl(req.getParameter("cl"));

        List<Object> list = new ArrayList<>();

        list.add(teacher.getName());
        list.add(teacher.getGender());
        list.add(teacher.getCollege());
        list.add(teacher.getCl());
        list.add(teacher.getId());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "update `teacher` set `tname` = ?,`gender` = ?,`college` = ?,`cl` = ? where tid = ?";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public Cl scanCl(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select cl.cid,cl`cname`,cl.`num`,teacher.tname from cl,teacher where teacher.`tid`= ?";

        List<Object> list = new ArrayList<>();
        list.add(req.getParameter("tid"));
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());

        Cl cl = new Cl();
        try {
            if (rs.next()) {
                cl.setId(rs.getInt("cid"));
                cl.setTid(Integer.parseInt(req.getParameter("tid")));
                cl.setName(rs.getString("cname"));
                cl.setNum(rs.getInt("num"));
                cl.setTname(rs.getString("tname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return cl;
    }

    public Teacher showTea(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from `teacher` where tid = ?";

        List<Object> list = new ArrayList<>();
        list.add(req.getParameter("tid"));
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());

        Teacher teacher = new Teacher();
        try {
            if (rs.next()) {
                teacher.setId(rs.getInt("tid"));
                teacher.setName(rs.getString("tname"));
                teacher.setGender(rs.getString("gender"));
                teacher.setCollege(rs.getString("college"));
                teacher.setCl(rs.getString("cl"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return teacher;
    }

    public int chooseCl(HttpServletRequest req, HttpServletResponse resp) {
        int cid = Integer.parseInt(req.getParameter("cid"));
        int sid = Integer.parseInt(req.getParameter("sid"));
        List<Object> list = new ArrayList<>();
        list.add(cid);
        list.add(sid);
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "update student set cid = ? where sid = ?";

        int temp = BaseDao.execute(conn, pstm, sql, list.toArray());//修改学生课程
        //System.out.println(temp);
        if (temp > 0) {
            List<Object> list1 = new ArrayList<>();
            list1.add(cid);
            sql = "select * from cl where cid = ?";
            ResultSet rs = null;
            rs = BaseDao.executeQuery(conn, pstm, rs, sql, list1.toArray());
            int num = 0;
            try {
                if (rs.next()) {
                    num = rs.getInt("num");//查人数
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list.remove(0);
            list.add(num + 1);
            list.add(cid);
            sql = "update cl set num = ? where cid = ?";//修改人数
            BaseDao.execute(conn, pstm, sql, list.toArray());
        }
        BaseDao.removeConnection(conn, pstm, null);
        return temp;
    }

    public List<Student> showStu(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from student where cid = ?";
        List<Student> list = new ArrayList<>();

        List<Object> lists = new ArrayList<>();
        lists.add(req.getParameter("cid"));
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, lists.toArray());

        try {
            while (rs.next()) {
                Student _stu = new Student();
                _stu.setId(rs.getInt("sid"));
                _stu.setName(rs.getString("sname"));
                _stu.setGender(rs.getString("gender"));
                _stu.setCl(rs.getString("cl"));
                _stu.setMajor(rs.getString("major"));
                list.add(_stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BaseDao.removeConnection(conn, pstm, rs);
        return list;
    }

    public List<Cl> showCl(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from cl";
        List<Cl> list = new ArrayList<>();

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, null);
        try {
            while (rs.next()) {
                Cl cl = new Cl();
                cl.setTid(rs.getInt("tid"));
                cl.setName(rs.getString("cname"));
                ResultSet _rs = null;
                sql = "select * from teacher where tid = ?";
                List _list = new ArrayList();
                _list.add(cl.getTid());
                _rs = BaseDao.executeQuery(conn, pstm, rs, sql, _list.toArray());
                if (_rs.next()) {
                    cl.setTname(_rs.getString("tname"));
                }
                list.add(cl);
                BaseDao.removeConnection(conn, pstm, _rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return list;
    }

    public Teacher teaById(int id) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from teacher where tid = ?";
        List<Object> list = new ArrayList<>();
        list.add(id);
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());
        Teacher teacher = new Teacher();
        try {
            if (rs.next()) {
                teacher.setId(rs.getInt("tid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return teacher;
    }

    public Student stuById(int id) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from student where sid = ?";
        List<Object> list = new ArrayList<>();
        list.add(id);
        System.out.println(id);
        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());
        Student student = new Student();
        try {
            if (rs.next()) {
                student.setId(rs.getInt("sid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return student;
    }

    public List<Cl> showStu(int tid) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from cl where tid = ?";
        List<Cl> list = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();
        list1.add(tid);

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list1.toArray());
        try {
            while (rs.next()) {
                Cl cl = new Cl();
                cl.setTid(rs.getInt("tid"));
                cl.setName(rs.getString("cname"));
                cl.setId(rs.getInt("cid"));
                cl.setNum(rs.getInt("num"));
                list.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.removeConnection(conn, pstm, rs);
        return list;
    }
}