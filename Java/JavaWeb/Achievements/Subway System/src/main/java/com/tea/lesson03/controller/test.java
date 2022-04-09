package com.tea.lesson03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/4/4 10:11
 */
@Controller
public class test {
//    @RequestMapping("/")
//    public String test(Model model){
//        model.addAttribute("cityNameWelcome","北京地铁欢迎您");
//        return "/index";
//    }

    @RequestMapping("/test")
    public String t(){
        return "/commons/commons";
    }
}
