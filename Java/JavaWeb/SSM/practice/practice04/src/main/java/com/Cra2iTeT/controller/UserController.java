package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.User;
import com.Cra2iTeT.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl service;

    //获取session中的id
    @PostMapping("/user/getSessionId")
    @ResponseBody
    public String getSessionId(HttpSession session) {
        //System.out.println(session.getAttribute("id"));
        return session.getAttribute("id").toString();
    }

    //获取session中的name
    @PostMapping("/user/getSessionName")
    @ResponseBody
    public String getSessionName(HttpSession session) {
        //System.out.println(session.getAttribute("name"));
        return session.getAttribute("name").toString();
    }

    //根据id返回信息
    @PostMapping("/user/showInfoById")
    @ResponseBody
    public String showInfoById(@RequestParam("id") int id) {
        return service.showInfoById(id).toString();
    }
}
