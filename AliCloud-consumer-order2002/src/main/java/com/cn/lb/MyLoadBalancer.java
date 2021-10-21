package com.cn.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author nchen
 * @Date 2021/10/20 17:12
 * @Version 1.0
 * @Description
 */
public interface MyLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
