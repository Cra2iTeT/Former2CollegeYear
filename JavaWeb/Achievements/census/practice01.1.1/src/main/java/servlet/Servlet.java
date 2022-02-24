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
            if (this.add(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"添加成功\");window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"添加失败\");window.location='Welcome.jsp'</script>");
            }
        } else if (method.equals("execute")) {
            req.setAttribute("name", req.getParameter("name"));
            req.getRequestDispatcher("Update.jsp").forward(req, resp);
        } else if (method.equals("update1")) {
            if (this.execute(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"修改成功\"); window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"修改失败\"); window.location='Welcome.jsp'</script>");
            }
        } else if (method.equals("delete")) {
            if (this.delete(req, resp) > 0) {
                resp.getWriter().print("<script> alert(\"删除成功\"); window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"删除失败\"); window.location='Welcome.jsp'</script>");
            }

        } else if (method.equals("query")) {
            List<Person> personList = this.query(req, resp);
            if (personList.size() == 0) {
                resp.getWriter().print("<script> alert(\"查询结果为空\"); window.location='Welcome.jsp'</script>");
            } else {
                req.setAttribute("personList", personList);
                req.getRequestDispatcher("Scan.jsp").forward(req, resp);
            }
        } else if (method.equals("show")) {
            Person person = (Person) this.getPerson(req, resp);
            req.setAttribute("person", person);
            req.getRequestDispatcher("Show.jsp").forward(req, resp);
        }
    }

    //删
    public int delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int end = 0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        String sql = "delete from `person` where `name` = ?";
        String[] params = new String[1];
        params[0] = name;

        end = BaseDao.execute(conn, pstm, sql, params);

        BaseDao.removeConnection(conn, pstm, null);

        return end;
    }

    //改
    public int execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int end = 0;
        Person pers = new Person();
        pers.setName(req.getParameter("name"));
        pers.setId(req.getParameter("id"));
        pers.setGender(req.getParameter("gender"));
        pers.setNation(req.getParameter("nation"));
        pers.setEdu(req.getParameter("edu"));

        List<Object> personList = new ArrayList<>();
        personList.add(pers.getId());
        personList.add(pers.getGender());
        personList.add(pers.getNation());
        personList.add(pers.getEdu());
        personList.add(pers.getName());

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;

        String sql = "update `person` set `id` = ?,`gender` = ?,`nation` = ?,`edu` = ? where name = ?";

        end = BaseDao.execute(conn, pstm, sql, personList.toArray());
        BaseDao.removeConnection(conn, pstm, null);
        return end;
    }

    //显示查询结果
    public List<Person> scan(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Person> personList = new ArrayList<>();
        String sql = "select * from `person`";

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, null);
        boolean flag = true;

        while (flag) {
            try {
                if (rs.next()) {
                    Person person = new Person();
                    person.setName(rs.getString("name"));
                    person.setGender(rs.getString("gender"));
                    person.setNation(rs.getString("nation"));
                    person.setEdu(rs.getString("edu"));

                    personList.add(person);
                } else {
                    flag = false;
                }
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        return personList;
    }

    //增
    public int add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Person person = new Person();
        person.setName(req.getParameter("name"));
        person.setHouseType(req.getParameter("houseType"));
        person.setHomeType(req.getParameter("homeType"));
        person.setArea(req.getParameter("area"));
        person.setRoomNum(req.getParameter("roomNum"));
        person.setId(req.getParameter("id"));
        person.setGender(req.getParameter("gender"));
        person.setNation(req.getParameter("nation"));
        person.setEdu(req.getParameter("edu"));

        List<Object> personList = new ArrayList<>();
        personList.add(person.getName());
        personList.add(person.getHouseType());
        personList.add(person.getHomeType());
        personList.add(person.getArea());
        personList.add(person.getRoomNum());
        personList.add(person.getId());
        personList.add(person.getGender());
        personList.add(person.getNation());
        personList.add(person.getEdu());

        Connection conn = BaseDao.getConnection();

        PreparedStatement pstm = null;
        String sql = "insert into `person` (`name`,`houseType`,`homeType`,`area`,`roomNum`,`id`,`gender`,`nation`,`edu`) values(?,?,?,?,?,?,?,?,?)";

        int insertEnding = BaseDao.execute(conn, pstm, sql, personList.toArray());
        BaseDao.removeConnection(conn, pstm, null);

        return insertEnding;
    }

    public Person getPerson(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from `person` where name = ?";
        List<Object> personList = new ArrayList<>();
        personList.add(req.getParameter("name"));

        rs = BaseDao.executeQuery(conn, pstm, rs, sql, personList.toArray());
        Person person = new Person();
        try {
            if (rs.next()) {
                person.setHouseType(rs.getString("houseType"));    //从结果集中读取相关数据
                person.setHomeType(rs.getString("homeType"));
                person.setArea(rs.getString("area"));
                person.setRoomNum(rs.getString("roomNum"));
                person.setName(rs.getString("name"));
                person.setId(rs.getString("id"));
                person.setGender(rs.getString("gender"));
                person.setNation(rs.getString("nation"));
                person.setEdu(rs.getString("edu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    //查询具体的数据
    public List<Person> query(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Person> personList = new ArrayList<>();    //往sql语句中写入相关的内容
        boolean flag = false;

        List<Object> list = new ArrayList<>();

        String sql = "select * from `person`";
        //System.out.println(req.getParameter("name"));

        if (!req.getParameter("name").equals(" ") && req.getParameter("name") != null) {
            String str = req.getParameter("name");
            //System.out.println(str);
            str += "%";
            list.add(str.substring(1));
            sql += " where name = ?";
            flag = true;
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
        if (!req.getParameter("nation").equals(" ") && req.getParameter("nation") != null) {
            if (flag) {
                sql += " and";
            } else {
                sql += " where";
            }
            sql += " nation like ?";
            flag = true;
            String str = req.getParameter("nation");
            //str.replace(" ", "");
            System.out.println(str.substring(1));
            str += "%";
            list.add(str.substring(1));
        }
        if (!req.getParameter("edu").equals(" ") && req.getParameter("edu") != null) {
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
                _person.setHouseType(rs.getString("houseType"));    //从结果集中读取相关数据
                _person.setHomeType(rs.getString("homeType"));
                _person.setArea(rs.getString("area"));
                _person.setRoomNum(rs.getString("roomNum"));
                _person.setName(rs.getString("name"));
                _person.setId(rs.getString("id"));
                _person.setGender(rs.getString("gender"));
                _person.setNation(rs.getString("nation"));
                _person.setEdu(rs.getString("edu"));
                personList.add(_person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BaseDao.removeConnection(conn, pstm, rs);
        return personList;
    }
}
