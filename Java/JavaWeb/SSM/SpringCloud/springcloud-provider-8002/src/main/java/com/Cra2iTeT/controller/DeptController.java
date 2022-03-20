package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.Dept;
import com.Cra2iTeT.service.impl.DeptServiceImpl;
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

    @GetMapping("/add")
    public int add(Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.query(id);
    }

    @GetMapping("/get")
    public List<Dept> get() {
        return deptService.queryAll();
    }

    //注册进来的微服务，获取消息
    @GetMapping("/dept/discovery")
    public Object discovery() {
        //获取微服务清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discoveryClient=>" + services);

        //得到一个具体的微服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()+"\t"+instance.getServiceId());
        }

        return this.discoveryClient;
    }

}
