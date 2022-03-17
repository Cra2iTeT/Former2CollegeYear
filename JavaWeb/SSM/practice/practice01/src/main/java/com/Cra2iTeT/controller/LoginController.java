package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.AdminUser;
import com.Cra2iTeT.service.impl.AdminUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AdminUserServiceImpl adminUserService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "../static/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {

        AdminUser user = adminUserService.login(username);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                session.setAttribute("user", user);
                return "redirect:/index.html";
            }
            model.addAttribute("msg", "密码错误");
            return "../static/login";
        }
        model.addAttribute("msg", "用户名错误");
        return "../static/login";
    }



}
