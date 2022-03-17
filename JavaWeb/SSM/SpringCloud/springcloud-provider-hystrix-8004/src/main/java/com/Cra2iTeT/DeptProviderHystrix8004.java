package com.Cra2iTeT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/10 18:59
 */
@SpringBootApplication
@EnableEurekaClient //开启向中心注册
@EnableHystrix  //开启熔断服务
public class DeptProviderHystrix8004 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8004.class, args);
    }
}
