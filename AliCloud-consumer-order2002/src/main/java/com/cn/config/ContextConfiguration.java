package com.cn.config;

/**
 * @Author nchen
 * @Date 2021/10/19 10:53
 * @Version 1.0
 * @Description
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ContextConfiguration {

    @Bean
    @LoadBalanced//不加这个使用RestTemplate调用会不知道哪个服务而报错(负载均衡)
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
