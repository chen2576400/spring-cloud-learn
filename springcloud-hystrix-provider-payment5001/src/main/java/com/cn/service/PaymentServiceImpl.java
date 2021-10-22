package com.cn.service;

import com.cn.result.Result;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author nchen
 * @Date 2021/10/18 16:53
 * @Version 1.0
 * @Description
 */
@Service
@DefaultProperties(defaultFallback = "payment_global_FallbackMethod")
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Result paymentInfo_ok(Integer id) {
        return Result.ok("线程池:"+Thread.currentThread().getName()+"paymentInfo_ok,id:"+id+"O(∩_∩)O哈哈~");
    }

    @Override
    //@HystrixCommand(fallbackMethod ="paymentInfo_timeoutHandler",commandProperties =
    //        {@HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})//超时或者异常都会触发
    @HystrixCommand
    public Result paymentInfo_timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.ok("线程池:"+Thread.currentThread().getName()+"paymentInfo_timeout,id:"+id+"O(∩_∩)O哈哈~"+"耗时8s");
    }



    public Result paymentInfo_timeoutHandler(Integer id) {
        return Result.ok("线程池:"+Thread.currentThread().getName()+"系统繁忙或运行报错"+id+"o(╥﹏╥)o");
    }



    public Result payment_global_FallbackMethod(){
        return Result.ok("全局异常处理，请稍后再试");
    }









    //================服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围10s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")}//失败率达到多少后跳闸
    )
    public Result paymentCircuitBreaker(Integer id) {
        if (id<0){
            throw new RuntimeException("*****ID 不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        return Result.ok(Thread.currentThread().getName()+"调用成功，流水号:"+serialNumber);
    }


    public Result paymentCircuitBreaker_fallback(Integer id) {
        return Result.ok("ID 不能为负数请稍后再试");
    }
}
