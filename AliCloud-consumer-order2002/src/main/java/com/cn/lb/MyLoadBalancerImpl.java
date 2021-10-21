package com.cn.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author nchen
 * @Date 2021/10/20 17:14
 * @Version 1.0
 * @Description 自定义负载均衡算法
 */
@Component
public class MyLoadBalancerImpl implements MyLoadBalancer{

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
             //获取当前值初始为0
            current=atomicInteger.get();
            //设置期望值
            next= current>= Integer.MAX_VALUE ?0:current+1;
            //当前状态值等于预期值，则以原子方式将同步状态设置为给定的更新值。
            // parm1 期望值，parm2更新值  如果atomicInteger原本值等于parm1则将atomicInteger的值更新为parm2 返回true，否则为false不操作
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*******第几次访问,次数next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index=getAndIncrement()%serviceInstances.size();

        return serviceInstances.get(index);
    }
}
