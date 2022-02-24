package com.Cra2iTeT.config;

import com.Cra2iTeT.bean.User;
import org.springframework.context.annotation.Bean;

//@Configuration
public class MyConfig {
    @Bean
    public User getUser(){
        return new User();
    }
}
