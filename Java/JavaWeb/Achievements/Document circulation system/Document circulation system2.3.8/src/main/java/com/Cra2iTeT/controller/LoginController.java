package com.Cra2iTeT.controller;

import com.Cra2iTeT.bean.Employee;
import com.Cra2iTeT.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    //登录
    @PostMapping("login")
    public String login(@RequestParam("id") int id,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        if (id == 8) {
            model.addAttribute("msg", "用户不存在");
        } else {
            Employee employee = loginService.queryEmployeeById(id);

            if (employee != null) {
                if (employee.getPassword().equals(password)) {

                    session.setAttribute("userName", employee.getName());
                    session.setAttribute("userId", employee.getId());
                    session.setAttribute("departId", employee.getDepartId());
                    session.setAttribute("jurisdictionNum", employee.getJurisdictionNum());

                    switch (employee.getDepartId()) {
                        case 0:
                            //管理员
                            return "./root/main";
                        case 1:
                            //主管
                            return "./manager/main";
                        case 5:
                            //办公室
                            return "./office/main";
                        default:
                            return "./employee/main";
                    }
                }
                model.addAttribute("msg", "密码错误");
            } else {
                model.addAttribute("msg", "用户不存在");
            }
        }

        return "/index";
    }
}
