【服务注册中心】:
Eureka(现在停止更新)
替代方案: Zookeeper  Consul  Nacos(推荐)
===============================================================================================
【服务调用】
服务调用一:
1、Ribbon(轻度患者)　　
2、LoadBalanced
服务调用二:    (Feign 是在 Ribbon的基础上进行了一次改进，是一个使用起来更加方便的 HTTP 客户端。采用接口的方式， 只需要创建一个接口，面向接口；然后在上面添加注解即可 ，将需要调用的其他服务的方法定义成抽象方法即可， 不需要自己构建http请求。然后就像是调用自身工程的方法调用，而感觉不到是调用远程方法，使得编写 客户端变得非常容易。)
1、Feigin(不推荐）
2、替代方案 OpenFeigin（推荐使用重点）
===============================================================================================
【服务降级】：
Hystrix（不推荐）
resilience4j（国外使用多）
alibaba Sentinel（国内使用多）
===============================================================================================
【服务网关】
Zuul（不推荐）
Zuul2（胎死腹中）
gateway（推荐）
===============================================================================================
【服务配置】
Config（不推荐）
Nacos（推荐）
===============================================================================================
【服务主线】
Bus（不推荐）
Nacos（推荐）
===============================================================================================







====================================【Eureka】=================================================
Server端
1.x与2.x区别
以前老版本（当前使用2018）
        <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-eureka</artifactId>
            </dependency>
现在新版本（当前使用2020.2）
        <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
            </dependency>
---------------------------------------------------------------------------------------------
client端
1.x与2.x区别
以前老版本（当前使用2018）
        <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-eureka</artifactId>
            </dependency>
现在新版本（当前使用2020.2）
        <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            </dependency>
            
Eureka 集群要修改host文件
127.0.0.1 Eureka3000.com    分别对应两个Eureka的instance的hostname，
127.0.0.1 Eureka3001.com      

eureka3000.com 或者eureka3001.com 其实都相当于127.0.0.1
集群配置完成后 http://eureka3000.com:3000/  能看到3000指向3001      
            http://eureka3001.com:3001/  能看到3001指向3000  
            
注册到Eureka后 可以使用RestTemplate外加负载均衡@LoadBalanced
采用注册服务名称来 调用服务而不再需要之前的 IP+端口号了
===============================================================================================