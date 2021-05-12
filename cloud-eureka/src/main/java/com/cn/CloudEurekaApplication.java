package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 */

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApplication.class, args);
    }


    /**
     * 如此配置打包后可以war包才可在tomcat下使用
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CloudEurekaApplication.class);
    }
}
