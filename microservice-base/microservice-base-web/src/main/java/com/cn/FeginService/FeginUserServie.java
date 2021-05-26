package com.cn.FeginService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @Author nchen
 * @Date 2021/5/26 15:30
 * @Version 1.0
 * @Description
 * name/value属性: 这两个的作用是一样的,指定的是调用服务的微服务名称
 * path: 定义当前FeignClient的统一前缀
 * fallback: 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑，fallback指定的类必须实现@FeignClient标记的接口
 */



@FeignClient(name ="microservice-job",path ="",fallback =FeginUserServieImpl.class )
public interface FeginUserServie {
    @RequestMapping(value="/user/findAllUser")
    public List findAllUser();
}
