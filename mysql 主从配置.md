```
mysql 主从配置
```

主服务器建立2进制日志，每产生语句或者磁盘变化，写进日志；

从服务器 建立relaylog   

```
#主库配置 my.ini文件
server_id=1
log_bin=mysql-bin
```

```

#从库配置  my.ini文件
server_id=2
relay_log = mysql-relay
```





1. ***\*查看主服务器是否开启binlog日志如果没有开启则开启，\****

   show variables like 'log_bin';

 show master status;（查询主数据master状态。（要求记录二进制文件名File以及其位置position）  ）

```sql
CREATE USER 'repl'@'&' IDENTIFIED WITH mysql_native_password BY '123456';
grant all privileges on *.* to 'repl'@'%' with grant option; 
GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%' #授权

flush privileges; 
```

2：从库设置

```
查看同步状态，slave_io_running=yes，说明开始同步
mysql>show slave status\G;
```

```
#推荐下面的
change master to master_host='192.168.1.114';
change master to master_port=3307;
change master to master_user='repl';
change master to master_password='123456';
change master to master_log_file='mysql-bin.000001';
change master to master_log_pos=5583;

```

```
start slave;
发现处于等待就ok
```

![image-20210610132715722](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210610132715722.png)





================mysql中间件 proxy============================================

https://www.cnblogs.com/wyt007/p/10762300.html

新建  mysql-proxy.conf文件
![image-20210610135951505](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210610135951505.png)

```
"D:\work\mysql-proxy\bin\mysql-proxy.exe" -P 192.168.1.110:6217 --defaults-file="D:\work\mysql-proxy\bin\mysql-proxy.conf"

```