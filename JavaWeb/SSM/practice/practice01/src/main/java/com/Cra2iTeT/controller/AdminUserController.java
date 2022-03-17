package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.AdminUser;
import com.Cra2iTeT.service.impl.AdminUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/AdminUser")
public class AdminUserController {
    @Autowired
    private AdminUserServiceImpl adminUserService;

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "/toAdd"; //转到添加页面，这个模板没有
    }

    @RequestMapping("/add")
    public String add(@RequestParam("id") Long id,
                      @RequestParam("userName") String userName,
                      @RequestParam("password") String password,
                      Model model) {
        AdminUser adminUser = new AdminUser(id, userName, password);
        if (adminUserService.addUser(adminUser) > 0) {
            model.addAttribute("msg", "添加成功");
        } else {
            model.addAttribute("msg", "添加失败");
        }
        return "redirect:../static/user.html";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate() {
        return "/update"; //跳转到修改用户数据页面，模板没有
    }

    @RequestMapping("update")
    public String update(HttpServletRequest req, Model model, HttpSession session) {
        HashMap<String, Object> hashMap = new HashMap<>();

        if (req.getParameter("userName") != null) {
            hashMap.put("userName", req.getParameter("username"));
        }
        if (req.getParameter("password") != null) {
            hashMap.put("password", req.getParameter("password"));
        }

        hashMap.put("id", req.getParameter("id"));

        if (adminUserService.updateUser(hashMap) > 0) {
            model.addAttribute("updateMsg", "修改成功");
        } else {
            model.addAttribute("updateMsg", "修改失败");
        }
        return "redirect:../static/user.html";
    }

    @RequestMapping("/test")
    public void test() {
        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("userName","root");
//        hashMap.put("password", "123456");
        hashMap.put("id", 2);

        adminUserService.updateUser(hashMap);
    }

}
