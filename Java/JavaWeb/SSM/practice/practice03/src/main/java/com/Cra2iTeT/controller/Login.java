package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.Worker;
import com.Cra2iTeT.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class Login {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public String login(@RequestParam("id") int id,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {

        Worker worker = loginService.login(id);

        if (worker != null && worker.getState() == 1) {   //账号存在且账号未停用
            if (password.equals(worker.getPassword())) {    //密码正确
                session.setAttribute("userName", worker.getName());
                return "./" + worker.getDid() + "/" + worker.getSid() + "/main";    //寻找对应页面
            }
            model.addAttribute("msg", "密码错误");
        } else {
            model.addAttribute("msg", "账号不存在或已停用");
        }
        return "/index";
    }
}
