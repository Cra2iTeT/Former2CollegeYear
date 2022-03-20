package response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class requestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String s1 = req.getParameter("userName");
        String s2 = req.getParameter("password");
        String[] values = req.getParameterValues("hobby");

        //System.out.println("中文");
        System.out.println("------------");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(Arrays.toString(values));
        System.out.println("------------");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");


    }
}
