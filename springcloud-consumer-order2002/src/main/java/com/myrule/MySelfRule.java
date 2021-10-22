package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author nchen
 * @Date 2021/10/20 16:20
 * @Version 1.0
 * @Description 虽然没纳入spring启动类容器管理，启动时候不会执行初始化，但是在第一次负载均衡调用时候会被执行
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return  new RandomRule();//定义为随机
    }
}
