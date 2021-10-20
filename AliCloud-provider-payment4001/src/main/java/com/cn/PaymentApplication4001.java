package com.cn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient//该注解用于向使用consul或zookeeper作为注册中心时注册服务
public class PaymentApplication4001 extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication4001.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PaymentApplication4001.class);
    }

}
