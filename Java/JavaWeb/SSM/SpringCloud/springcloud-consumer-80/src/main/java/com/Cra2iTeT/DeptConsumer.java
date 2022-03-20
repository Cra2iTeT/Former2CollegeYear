package com.Cra2iTeT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/10 22:41
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer.class, args);
    }
}
