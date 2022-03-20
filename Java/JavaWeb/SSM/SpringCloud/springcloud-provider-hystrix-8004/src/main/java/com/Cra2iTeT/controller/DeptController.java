package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.Dept;
import com.Cra2iTeT.service.impl.DeptServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/9 22:58
 */
@RestController
public class DeptController {
    private final DeptServiceImpl deptService;

    private final DiscoveryClient discoveryClient;

    public DeptController(DeptServiceImpl deptService, DiscoveryClient discoveryClient) {
        this.deptService = deptService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.query(id);

        if (dept == null) {
            throw new RuntimeException("id => " + id + ",不存在该用户,或者信息无法找到");
        }

        return dept;
    }

    //备选
    public Dept hystrixGet(@PathVariable("id") Long id) {
        return new Dept()
                .setDNo(id)
                .setDName("id => " + id + "没有对应信息,null--@Hystrix")
                .setDb_source("no this database");
    }
}
