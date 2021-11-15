package com.cn.feign;

import com.cn.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author nchen
 * @Date 2021/11/15 15:56
 * @Version 1.0
 * @Description
 */
@FeignClient(value = "alibabacloud-provider-payment8412",path ="/payment",fallback = PaymentFallbackService.class )
public interface PaymentService {
    @RequestMapping(value = "/paymentSQL/{id}")
    public Result getPayment(@PathVariable("id") Integer id);
}
