package com.Cra2iTeT.servlet.user;

import com.Cra2iTeT.pojo.User;
import com.Cra2iTeT.service.user.UserService;
import com.Cra2iTeT.service.user.UserServiceImpl;
import com.Cra2iTeT.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet");

        //获取用户名密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //和数据库的密码对比，调用业务层
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        if (user != null) {//找到了
            //将用户的信息放到Session中
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            //跳转到主页
            resp.sendRedirect(req.getContextPath() + "jsp/frame.jsp");
        } else {//查无此人
            //提示
            req.setAttribute("error", "用户名或密码不正确");
            //转回登录页
            req.getRequestDispatcher(req.getContextPath() + "login.jsp").forward(req, resp);
        }
    }
}
