package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AJAXController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse resp) throws IOException {
        System.out.println("a1接收了：" + name);
        if ("Cra2iTeT".equals(name)) {
            resp.getWriter().print("true");
        } else {
            resp.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        List<User> list = new ArrayList<>();

        list.add(new User("Cra2iTeT1", 1, "男"));
        list.add(new User("Cra2iTeT2", 2, "男"));
        list.add(new User("Cra2iTeT3", 3, "男"));
        list.add(new User("Cra2iTeT4", 4, "男"));

        return list;    //@RestController将list转成Json格式
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd) {
        String msg = "";
        if (name != null) {
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名有误";
            }
        }
        if (pwd != null) {
            if ("123456".equals(pwd)) {
                msg = "ok";
            } else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
