笔记网站：https://www.yuque.com/books/share/31d864d1-b6ff-4bd1-8569-2dec720e8306/fncn1y

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
            
Eureka 集群 （这里采用的3000和3001）
要修改host文件
127.0.0.1 Eureka3000.com    分别对应两个Eureka的instance的hostname，
127.0.0.1 Eureka3001.com      

eureka3000.com 或者eureka3001.com 其实都相当于127.0.0.1
集群配置完成后 http://eureka3000.com:3000/  能看到3000指向3001      
            http://eureka3001.com:3001/  能看到3001指向3000  
            
注册到Eureka后 可以使用RestTemplate外加负载均衡@LoadBalanced
采用注册服务名称来 调用服务而不再需要之前的 IP+端口号了
===============================================================================================



====================================【zookeeper】=================================================
Server端：去网上下载tar.gz  
1:conf目录下  修改zoo_sample.cfg重命名为zoo.cfg
2：在根目录下新件一个data  和log空目录
3:dataDir=/tmp/zookeeper修改成zookeeper安装目录所在的data文件夹(dataDir=D:\\work\\zookeeper\\apache-zookeeper-3.5.9\\data)
再加上日志输出目录dataLogDir=D:\\work\\zookeeper\\apache-zookeeper-3.5.9\\log

在引入zookeeper依赖时候  要和自己下载的版本一致,否则无法启动（一般先排除其他版本在依赖自己的版本）
====================================【zookeeper】=================================================



====================================【nacos】=================================================
Server端：去网上下载   启动分为集群版(需要建库)  和单机版
nacos自带一个数据库 如果想换成本地mysql数据库 （mysql8+需要在nacos目录下面新建/plugins/mysql 把驱动jar放进去  貌似1.3+nacos支持了mysql8+）
1：去nacos的conf目录找到 nacos-mysql.sql 执行sql
2：然后修改conf目录下面 application.properties  增加
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=root
db.password=123456
windows启动 startup.cmd -m standalone




nacos-conig 配置方案
一：DataID方案
采取的是默认空间+默认分组+    自定义yaml文件(${prefix}-${spring.profiles.active}.${file-extension})
指定spring.profile.active和配置文件的DataID来使不同环境下读取不同的配置
通过spring.profile.active属性就能进行多环境下的配置文件的读取。


二：Group方案 （通过Group实现环境区分）
采取的是默认空间+自定义分组+     自定义yaml文件(${prefix}-${spring.profiles.active}.${file-extension}) 
nacos.config.group 属性绑定自定义分组名称
通过spring.profile.active属性就能进行多环境下的配置文件的读取。

三： Namespace方案 通过（Namespace方案实现环境区分）
采取的是自定义空间+自定义分组+    自定义yaml文件(${prefix}-${spring.profiles.active}.${file-extension})
====================================【nacos】=================================================







