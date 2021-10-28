package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author nchen
 * @Date 2021/10/22 13:57
 * @Version 1.0
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqMainApplication2802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMainApplication2802.class, args);
    }
}
