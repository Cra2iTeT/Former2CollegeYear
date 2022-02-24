package servlet;

import dao.BaseDao;
import pojo.Stu;

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
    private BaseDao baseDao;

    public Servlet() {
        baseDao = new BaseDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String method = req.getParameter("method");

        if (method.equals("add")) {
            if (this.add(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"Insert successfully\"); window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"Insert failed\"); window.location='Welcome.jsp'</script>");
            }
            //req.getRequestDispatcher("Welcome.jsp").forward(req, resp);
        } else if (method.equals("delete")) {
            if (this.delete(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"Delete successfully\"); window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"Delete failed\"); window.location='Welcome.jsp'</script>");
            }
        } else if (method.equals("update")) {
            req.setAttribute("id", req.getParameter("id"));
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        } else if (method.equals("update1")) {
            if (this.update(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"Update successfully\"); window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"Update failed\"); window.location='Welcome.jsp'</script>");
            }
        } else if (method.equals("query")) {
            List<Stu> stuList = this.query(req, resp);
            if (stuList.size() == 0) {
                resp.getWriter().print("<script> alert(\"The query result is empty\"); window.location='Welcome.jsp'</script>");
            } else {
                req.setAttribute("stuList", stuList);
                req.getRequestDispatcher("allQuery.jsp").forward(req, resp);
            }
        } else if (method.equals("allQuery")) {
            List<Stu> stuList = allQuery(req, resp);
            req.setAttribute("stuList", stuList);
            req.getRequestDispatcher("allQuery.jsp").forward(req, resp);
        }
    }

    //增加
    public int add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Stu stu = new Stu();
        stu.setId(Integer.parseInt(req.getParameter("id")));
        stu.setName(req.getParameter("name"));
        stu.setClassname(req.getParameter("classname"));
        stu.setGender(req.getParameter("gender"));
        int executeRows = 0;

        if (!modifyId(stu.getId())) {
            resp.getWriter().print("<script> alert(\"Duplicate ID\"); window.location='Welcome.jsp'</script>");
        }

        List<Object> stuList = new ArrayList<>();
        stuList.add(stu.getId());
        stuList.add(stu.getName());
        stuList.add(stu.getClassname());
        stuList.add(stu.getGender());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;

        String sql = "insert into `student` (`id`, `name`, `classname`, `gender`) values (?,?,?,?)";

        executeRows = BaseDao.execute(conn, pstm, sql, stuList.toArray());
        BaseDao.removeConnection(conn, pstm, null);

        return executeRows;
    }

    //检查学号是否重复
    public boolean modifyId(int id) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "select COUNT(1) from `student` where id = ?";
        Object[] params = new Object[1];
        params[0] = id;

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, params);

        try {
            if (rs.next()) {
                return false;//重复返回false
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    //查找具体的
    public List<Stu> query(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Stu> stuList = new ArrayList<>();
        boolean flag = false;

        List<Object> list = new ArrayList<>();

        String sql = "select * from `student`";

        //System.out.println(req.getParameter("gender"));

        if (!req.getParameter("id").equals(" ")) {
            sql += " where id = ?";
            flag = true;
            list.add(req.getParameter("id"));
        }
        if (!req.getParameter("name").equals(" ")) {
            if (flag) {
                sql += " and";
            } else {
                sql += " where";
            }
            sql += " name = ?";
            flag = true;
            list.add(req.getParameter("name"));
        }
        if (!req.getParameter("classname").equals(" ")) {
            if (flag) {
                sql += " and";
            } else {
                sql += " where";
            }
            sql += " classname = ?";
            flag = true;
            list.add(req.getParameter("classname"));
        }
        if (req.getParameter("gender") != null) {
            if (flag) {
                sql += " and";
            } else {
                sql += " where";
            }
            sql += " gender = ?";
            flag = true;
            list.add(req.getParameter("gender"));
        }

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());

        try {
            while (rs.next()) {
                Stu _stu = new Stu();
                _stu.setId(rs.getInt("id"));
                _stu.setName(rs.getString("name"));
                _stu.setClassname(rs.getString("classname"));
                _stu.setGender(rs.getString("gender"));
                stuList.add(_stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BaseDao.removeConnection(conn, pstm, rs);
        return stuList;
    }

    //返回全部数据
    public List<Stu> allQuery(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Stu> stuList = new ArrayList<>();

        String sql = "select * from `student`";

        String method = req.getParameter("MySelect");

        if (method != null && method.equals("idASC")) {
            sql += " order by id asc";
        } else if (method != null && method.equals("idDESC")) {
            sql += " order by id desc";
        } else if (method != null && method.equals("classnameASC")) {
            sql += " order by classname asc";
        } else if (method != null && method.equals("classnameDESC")) {
            sql += " order by classname desc";
        }

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, null);
        Boolean flag = true;

        while (flag) {
            try {
                if (rs.next()) {
                    Stu _stu = new Stu();
                    _stu.setId(rs.getInt("id"));
                    _stu.setName(rs.getString("name"));
                    _stu.setClassname(rs.getString("classname"));
                    _stu.setGender(rs.getString("gender"));
                    stuList.add(_stu);
                } else {
                    flag = false;
                }
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }

        }

        BaseDao.removeConnection(conn, pstm, rs);
        return stuList;
    }

    //修改
    public int update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int executeRows = 0;

        Stu stu = new Stu();
        stu.setName(req.getParameter("name"));
        stu.setClassname(req.getParameter("classname"));
        stu.setGender(req.getParameter("gender"));

        List<Object> stuList = new ArrayList<>();
        stuList.add(stu.getName());
        stuList.add(stu.getClassname());
        stuList.add(stu.getGender());
        stuList.add(id);

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;

        String sql = "update `student` set `name` = ?,`classname` = ?,`gender` = ? where id = ?";


        executeRows = BaseDao.execute(conn, pstm, sql, stuList.toArray());

        if (executeRows > 0) {
            resp.getWriter().print("<script> alert(\"Execute successfully\") </script>");
        } else {
            resp.getWriter().print("<script> alert(\"Execute failed\") </script>");
        }

        BaseDao.removeConnection(conn, pstm, null);

        return executeRows;
    }

    //删除
    public int delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int executeRows = 0;

        if (!modifyId(id)) {//先找得到该用户
            Connection conn = BaseDao.getConnection();
            PreparedStatement pstm = null;

            String sql = "delete from `student` where id = ?";

            Object[] params = new Object[1];
            params[0] = id;

            executeRows = BaseDao.execute(conn, pstm, sql, params);

            BaseDao.removeConnection(conn, pstm, null);
        } else {
            resp.getWriter().print("<script> alert(\"ID not found\") </script>");
        }

        return executeRows;
    }

}