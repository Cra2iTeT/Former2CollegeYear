package com.Cra2iTeT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/11 9:42
 */
@SpringBootApplication
@EnableEurekaServer //服务端启动类，可以接受别人注册进来
public class eurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(eurekaServer_7003.class,args);
    }
}
