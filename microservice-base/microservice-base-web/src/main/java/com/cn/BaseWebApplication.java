package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
public class BaseWebApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BaseWebApplication.class, args);
    }

    /**
     * 如此配置打包后可以war包才可在tomcat下使用
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BaseWebApplication.class);
    }
}
