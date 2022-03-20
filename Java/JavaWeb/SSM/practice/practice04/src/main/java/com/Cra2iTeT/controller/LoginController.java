package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.User;
import com.Cra2iTeT.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl service;

    @RequestMapping(value = {"/", "/index.html", "/index"})
    public String index() {
        return "index";
    }

    //登录
    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestParam("id") int id,
                      @RequestParam("password") String password,
                      HttpSession session,
                      HttpServletResponse resp) throws IOException {
        //System.out.println("==>我在这");

        User user = service.login(id);

        //账号存在
        if (user != null) {
            //密码匹对
            if (password.equals(user.getPassword())) {
                session.setAttribute("id", user.getId());
                //System.out.println("id=>" + user.getId());
                session.setAttribute("name", user.getName());
                resp.getWriter().print("login success");
            } else {
                resp.getWriter().print("password error");
            }
        } else {
            resp.getWriter().print("id error");
        }
    }
}
