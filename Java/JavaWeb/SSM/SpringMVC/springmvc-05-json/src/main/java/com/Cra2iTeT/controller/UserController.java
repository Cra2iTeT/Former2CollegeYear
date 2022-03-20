package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController   //也不走视图解析器
public class UserController {

    @SneakyThrows
    //@RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @RequestMapping("/j1")
    @ResponseBody   //就不会走视图解析器，会直接返回一个字符串
    public String json1() {

        ObjectMapper mapper = new ObjectMapper();


        User user = new User("Cra2iTeT", 3, "男");

        String str = mapper.writeValueAsString(user);

        return str;
    }

    @SneakyThrows
    //@RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @RequestMapping("/j2")
    @ResponseBody   //就不会走视图解析器，会直接返回一个字符串
    public String json2() {

        List<User> list = new ArrayList<>();

        User user1 = new User("Cra2iTeT", 3, "男");
        User user2 = new User("Cra2iTeT", 4, "男");
        User user3 = new User("Cra2iTeT", 5, "男");
        User user4 = new User("Cra2iTeT", 6, "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return new ObjectMapper().writeValueAsString(list);
    }
}
