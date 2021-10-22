package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author nchen
 * @Date 2021/10/22 13:57
 * @Version 1.0
 * @Description
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMainApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMainApplication3344.class, args);
    }
}
