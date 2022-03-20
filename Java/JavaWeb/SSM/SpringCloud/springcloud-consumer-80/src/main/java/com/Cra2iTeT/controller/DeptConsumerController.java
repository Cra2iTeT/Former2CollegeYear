package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/10 19:42
 */
@RestController
public class DeptConsumerController {

    private final RestTemplate restTemplate;
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //Ribbon 这里的地址应该是一个变量，通过服务名访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    public DeptConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/get/{id}" + id, Dept.class);
    }

    @GetMapping("/consumer/dept/get")
    public List<Dept> get() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/get", List.class);
    }

    @GetMapping("/consumer/dept/add")
    public int add(Dept dept) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/add", Integer.class);
    }

}
