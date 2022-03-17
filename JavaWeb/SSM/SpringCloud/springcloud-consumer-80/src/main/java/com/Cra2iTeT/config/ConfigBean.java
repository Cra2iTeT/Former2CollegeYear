package com.Cra2iTeT.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/10 22:28
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced   //Ribbon配置负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
