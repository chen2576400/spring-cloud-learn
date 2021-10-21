package com.cn.web;

import com.cn.result.Result;
import com.cn.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author nchen
 * @Date 2021/10/18 17:04
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("consumer")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeginService;


    /**
     * http://localhost:5002/consumer/get/3
     */
    @GetMapping("get/{id}")
    public Result getZookeeperMsg(@PathVariable("id") Long id) {
        Result result = paymentFeginService.getResult(id);
        return result;
    }

    /**
     * http://localhost:5002/consumer/feginTimeout
     */
    @RequestMapping("feginTimeout")
    public Result paymentFeginTimeout() {
        Result result = paymentFeginService.paymentFeginTimeout();
        return result;
    }

}
