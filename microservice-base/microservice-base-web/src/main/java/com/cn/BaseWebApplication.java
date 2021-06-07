package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableHystrix  /** @EnableHystrix或者@EnableCircuitBreaker-开启熔断器**/
@EnableEurekaClient  /** 它们都能够让注册中心发现，并扫描到该服务 **/
@EnableFeignClients   /**如果不写包名默认找启动类包下面的feignClient 供模块调用*/
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
