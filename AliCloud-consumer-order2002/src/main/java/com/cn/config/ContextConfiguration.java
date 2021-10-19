package com.cn.config;

/**
 * @Author nchen
 * @Date 2021/10/19 10:53
 * @Version 1.0
 * @Description
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ContextConfiguration {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
