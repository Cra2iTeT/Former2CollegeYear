package servlet;

import bean.Person;
import dao.BaseDao;

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

        if (method.equals("add")) {

        } else if (method.equals("execute")) {

        } else if (method.equals("delete")) {

        } else if (method.equals("query")) {
            List<Person> personList = this.query(req, resp);
            if (personList.size() == 0) {
                resp.getWriter().print("<script> alert(\"查询结果为空\"); window.location='Welcome.jsp'</script>");
            } else {
                req.setAttribute("personList", personList);
                req.getRequestDispatcher("Scan.jsp").forward(req, resp);
            }
        }
    }

    public List<Person> query(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Person> personList = new ArrayList<>();
        boolean flag = false;

        List<Object> list = new ArrayList<>();

        String sql = "select * from `person`";

        if (!req.getParameter("name").equals(" ")) {
            sql += " where name = ?";
            flag = true;
            list.add(req.getParameter("name"));
        }
        if (!req.getParameter("gender").equals(" ")) {
            if (flag) {
                sql += " and";
            } else {
                sql += " where";
            }
            sql += " gender = ?";
            flag = true;
            list.add(req.getParameter("gender"));
        }
        if (!req.getParameter("nation").equals(" ")) {
            if (flag) {
                sql += " and";
            } else {
                sql += " where";
            }
            sql += " nation = ?";
            flag = true;
            list.add(req.getParameter("nation"));
        }
        if (req.getParameter("edu") != null) {
            if (flag) {
                sql += " and";
            } else {
                sql += " where";
            }
            sql += " edu = ?";
            flag = true;
            list.add(req.getParameter("edu"));
        }

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, list.toArray());

        try {
            while (rs.next()) {
                Person _person = new Person();
                _person.setHouseType(rs.getString("houseType"));
                _person.setHouseType(rs.getString("homeType"));
                _person.setHouseType(rs.getString("area"));
                _person.setHouseType(rs.getString("roomNum"));
                _person.setHouseType(rs.getString("name"));
                _person.setHouseType(rs.getString("id"));
                _person.setHouseType(rs.getString("gender"));
                _person.setHouseType(rs.getString("nation"));
                _person.setHouseType(rs.getString("edu"));
                personList.add(_person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BaseDao.removeConnection(conn, pstm, rs);
        return personList;
    }
}
