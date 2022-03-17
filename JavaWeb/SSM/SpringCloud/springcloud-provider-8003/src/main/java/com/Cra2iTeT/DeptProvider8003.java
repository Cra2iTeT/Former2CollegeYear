package com.Cra2iTeT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/10 18:59
 */
@SpringBootApplication
@EnableEurekaClient //开启向中心注册
public class DeptProvider8003 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003.class,args);
    }
}
