package com.cn.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author nchen
 * @Date 2021/10/21 11:21
 * @Version 1.0
 * @Description
 */
@Configuration
public class FeginConfig {
    @Bean
    Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
