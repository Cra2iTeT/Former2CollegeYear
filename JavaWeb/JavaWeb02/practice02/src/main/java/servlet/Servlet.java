package servlet;

import bean.Stu;
import dao.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        resp.setContentType("text/html;charset=UTF-8");

        Stu stu = new Stu();

        stu.setId(req.getParameter("id"));
        stu.setName(req.getParameter("name"));
        stu.setAcademy(req.getParameter("academy"));
        stu.setPhone(req.getParameter("phone"));
        stu.setColor(req.getParameter("color"));
        stu.setGrade(req.getParameter("grade"));
        stu.setPosition(req.getParameter("position"));
        stu.setOther(req.getParameter("other"));


        List<Object> list = new ArrayList<>();

        list.add(stu.getName());
        list.add(stu.getId());
        list.add(stu.getAcademy());
        list.add(stu.getPhone());
        list.add(stu.getColor());
        list.add(stu.getOther());
        list.add(stu.getGrade());
        list.add(stu.getPosition());

        String sql = "insert into `Ls` (`name`, `id`, `academy`, `phone`,`color`,`other`,`grade`,`position`) values (?,?,?,?,?,?,?,?)";

        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;

        int executes = BaseDao.execute(conn, pstm, sql, list.toArray());

        BaseDao.removeConnection(conn, pstm, null);

        if (executes > 0) {
            resp.getWriter().print("<script> alert('添加成功'); window.location='add.jsp'</script>");
        } else {
            resp.getWriter().print("<script> alert('添加失败'); window.location='add.jsp'</script>");
        }
    }
}
