package com.cn.service;

import com.cn.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Author nchen
 * @Date 2021/10/21 10:39
 * @Version 1.0
 * @Description
 */

/**
这个value值要和yml里面的name一样，区分大小写
*/
@FeignClient(value = "AliCloud-provider-payment2001",path ="/payment")
public interface PaymentFeginService {
    @GetMapping("get/{id}")
     Result getResult(@PathVariable("id") Long id);

    @RequestMapping("paymentFeginTimeout")
     Result  paymentFeginTimeout();
}
