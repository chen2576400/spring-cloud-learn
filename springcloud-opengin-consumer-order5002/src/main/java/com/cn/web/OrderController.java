package com.cn.web;

import com.cn.result.Result;
import com.cn.service.PaymentFeignService;
import com.cn.service.PaymentHystrixFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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


    @Resource
    private PaymentHystrixFeignService hystrixFeignService;


    /**
     * 调用2001
     * http://localhost:5002/consumer/get/3
     */
    @GetMapping("get/{id}")
    public Result getZookeeperMsg(@PathVariable("id") Long id) {
        Result result = paymentFeginService.getResult(id);
        return result;
    }

    /**
     * 调用2001
     * http://localhost:5002/consumer/feginTimeout
     */
    @RequestMapping("feginTimeout")
    public Result paymentFeginTimeout() {
        Result result = paymentFeginService.paymentFeginTimeout();
        return result;
    }


    /**
     * 调用hystrix的5001
     * http://localhost:5002/consumer/ok/1
     */
    @RequestMapping("ok/{id}")
    public Result ok(@PathVariable("id") Integer id) {
        return  hystrixFeignService.ok(id);
    }

    /**
     * 调用hystrix的5001
     * http://localhost:5002/consumer/timeout/1
     */
    @RequestMapping("timeout/{id}")
    public Result timeout(@PathVariable("id") Integer id) {
        return  hystrixFeignService.timeout(id);
    }


}
