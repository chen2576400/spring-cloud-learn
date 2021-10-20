

#                    docker**的使用**

## 1. docker的安装

```
1 查看 CentOS内核版本    Docker 要求CentOS 系统的内核版本高于3.10  
uname  -r
2 安装docker
yum install  docker
3 输入y确认安装
4 启动docker
[nchen@localhost ~]$ sudo systemctl start docker
[sudo] password for nchen: 
[nchen@localhost ~]$ docker -v
Docker version 1.13.1, build 0be3e21/1.13.1
5 开机启动docker
sudo systemctl enable docker
6 停止docker
sudo systemctl stop docker
7 重启docker
sudo systemctl restart docker

```
service firewalld status   --查看防火墙状态
service firewalld stop     --关闭防火墙
------


##使用阿里云镜像加速器


[root@localhost ~]# mkdir -p /etc/docker
[root@localhost ~]# tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://9cpn8tt6.mirror.aliyuncs.com"]
}
EOF
[root@localhost ~]# systemctl daemon-reload
[root@localhost ~]# systemctl restart docker



------

 <!--如果出现启动失败情况处理-->

```
CentOS7安装docker 启动失败：Job for docker.service failed… 解决办法
查看docker 版本，只有client,没有server。
```

![这里写图片描述](https://img-blog.csdn.net/2018091220013414?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xpeGlhb3lhb2JveQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

```
**解决**：执行 vi /etc/sysconfig/selinux , 把 selinux 属性值改为disabled。然后重启系统，docker就可以启动啦。。。
```

![这里写图片描述](https://img-blog.csdn.net/20180912200633396?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xpeGlhb3lhb2JveQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

------

------

## 2. docker常用操作

#### 1：镜像操作

| 操作 | 命令                                                         | 说明                                                         |
| ---- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| 检索 | docker search 关键字体<br />eg： docker search  redis        | 我们经常去 docker Hub上检索镜像的详细信息，如镜像的Tag       |
| 拉取 | docker pull 镜像名.tag<br />eg:docker pull mysql:5.7<br />docker pull docker.io/mysql | :tag是可选的，tag表示标签，多为软件的版本，默认为last<br />前面的docker.io 可以省略 也可以加上 |
| 列表 | docker images                                                | 查看本地所有镜像                                             |
| 删除 | docker rmi image  -id<br />eg:docker rmi image cd0f0b1e283d  | 删除指定的本地镜像                                           |







#### 2：容器操作

| 操作     | 命令                                                         | 说明                                                         |
| -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 运行     | docker run -name  container -name -d  image-name<br />eg:   docker run --name **mysqlName** -d **docker.io/mysql**:latest | --name:自定义容器名<br />-d:后台运行<br />image-name:指定镜像模板<br />参数一：自定义名字<br />参数二：REPOSITORY（镜像名字 **docker.io/mysql）<br />参数三：指定tag（:latest）当前默认<br /> |
| 列表     | docker ps (查看运行中的容器)                                 | 加上 -a; 可以查看所有容器                                    |
| 停止     | docker stop container-name/container-id                      | 停止当前你运行的容器                                         |
| 启动     | docker start container-name/container-id                     | 启动容器                                                     |
| 删除     | docker rm  container-id                                      | 删除指定容器                                                 |
| 端口映射 | -p 6379:6379                                                 | -p:主机端口（映射到）容器内部端口                            |
| 容器日志 | docker logs  container-name/container-id                     |                                                              |
| 更多命令 |                                                              |                                                              |

```
总体步骤
1：检索镜像
docker search  mysql
2：拉取镜像
docker pull 镜像名.tag    不加标签就默认last
3：根据镜像启动容器
docker run --name mysqlName -d docker.io/mysql:latest
4:查看运行中的容器
docker ps
5：停止运行中的容器
docker stop  容器的ID
6：查看所有容器
docker ps -a
7 启动容器
docker start 容器id
8 删除一个容器
docker rm  容器id
9 启动一个做了端口映射的tomcat
docker run -d -p 8888:8080 tomcat
-d 后台运行  -p:主机端口（映射到）容器内部端口   主机端口：容器端口
10 为了方便关闭了linux防火墙
service firewalld status   --查看防火墙状态
service firewalld stop     --关闭防火墙

```





**mysql错误的启动方式**

```
docker run --name mysql01 -d mysql
```

docker ps -a 错误显示

```
mysql 退出了

CONTAINER ID        IMAGE                    COMMAND                  CREATED             STATUS                      PORTS                 NAMES
fdecaa213b10        mysql                    "docker-entrypoint..."   6 minutes ago       Exited (1) 6 minutes ago                          cocky_davinci
125f1f00e167        mysql                    "docker-entrypoint..."   11 minutes ago      Exited (1) 11 minutes ago                         gifted_goldwasser
1e6968c387e9        mysql:latest             "docker-entrypoint..."   22 minutes ago      Created                     3306/tcp, 33060/tcp   mysql
773cd9c12706        docker.io/mysql:latest   "docker-entrypoint..."   37 minutes ago      Created                     3306/tcp, 33060/tcp   mysqlName

```





**mysql 正确启动方式**

```
docker run --name mysql01 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
docker run -p 3309:3306 --name mysql01 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
(映射端口    主机3309映射到虚拟机3306)

在本机登录mysql
docker exec -it 容器id mysql -uroot -p123456

select host,user,plugin from mysql.user;
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'newpassword'; #更新一下用户
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';#更新一下用户
的密码 root用户密码为newpassword()   


```









# redis 安装启动

```
1： docker search redis
2: docker pull redis / docker pull redis:tag

3:下载一个redis.conf文件 修改好 不然远程无法访问
bind 127.0.0.1 #注释掉这部分，使redis可以外部访问
daemonize no#用守护线程的方式启动
requirepass 你的密码#给redis设置密码
appendonly yes#redis持久化　　默认是no
tcp-keepalive 300 #防止出现远程主机强迫关闭了一个现有的连接的错误 默认是300

4：mkdir /usr/local/docke; 新建一个目录 将下载好的redis.conf文件放进去 
 如果xftp无法传输  赋予权限  （chmod -R 777 /usr/local/docke）
 
5 以conf文件方式启动 
docker run -p 6333:6379 --name myredis -v /usr/local/docker/redis.conf:/etc/redis/redis.conf -v /usr/local/docker/data:/data -d redis:6.0.8 redis-server /etc/redis/redis.conf --appendonly yes

docker run -p 6334:6379 --name myredis -v /usr/local/docker/redis.conf:/etc/redis/redis.conf -v /usr/local/docker/data:/data -d redis:6.0.8 redis-server /etc/redis/redis.conf --appendonly yes

```

