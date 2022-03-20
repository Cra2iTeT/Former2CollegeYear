package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class IndexController {

    @RequestMapping("login")
    public String login(String username, String password) throws IOException {
        if (username.equals("admin")) {
            if (password.equals("123456")) {
                return "main";
            }
        }
    }
}
