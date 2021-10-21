package com.cn;
import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
/**Name是Ribbon要访问的客户端的名称，如果省略表示配置所有客户端(以视图工具里面的为准 大小写注意)  configuration是自定义负载均衡算法类*/
//@RibbonClient(name = "ALICLOUD-PROVIDER-PAYMENT2001",configuration = MySelfRule.class )
public class ConsumerApplication2002 extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication2002.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ConsumerApplication2002.class);
    }

}
