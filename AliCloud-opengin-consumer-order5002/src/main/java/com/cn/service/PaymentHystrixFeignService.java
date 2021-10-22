package com.cn.service;

import com.cn.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author nchen
 * @Date 2021/10/21 14:18
 * @Version 1.0
 * @Description
 */
@FeignClient(value = "AliCloud-hystrix-provider-payment5001",path ="/payment",fallback =PaymentHystrixFeignFallbackServiceImpl.class)
public interface PaymentHystrixFeignService {

    @RequestMapping("ok/{id}")
    Result ok(@PathVariable("id") Integer id);

    @RequestMapping("timeout/{id}")
    public Result timeout(@PathVariable("id") Integer id);
}
