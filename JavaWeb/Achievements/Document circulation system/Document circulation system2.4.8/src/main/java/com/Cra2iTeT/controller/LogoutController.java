package com.Cra2iTeT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    //注销登陆
    @PostMapping("logout")
    public String logout(HttpSession httpSession,
                         Model model) {
        System.out.println("====================");
        System.out.println("logoutController函数中");

        System.out.println("注销前:");
        System.out.println("userName=>" + httpSession.getAttribute("userName"));
        System.out.println("userId=>" + httpSession.getAttribute("userId"));
        System.out.println("departId=>" + httpSession.getAttribute("departId"));

        httpSession.removeAttribute("userName");
        httpSession.removeAttribute("userId");
        httpSession.removeAttribute("departId");
        model.addAttribute("msg", "登录注销成功");

        System.out.println();
        System.out.println("注销后:");
        System.out.println("userName=>" + httpSession.getAttribute("userName"));
        System.out.println("userId=>" + httpSession.getAttribute("userId"));
        System.out.println("departId=>" + httpSession.getAttribute("departId"));

        System.out.println("====================");
        System.out.println();

        return "/index";
    }
}
