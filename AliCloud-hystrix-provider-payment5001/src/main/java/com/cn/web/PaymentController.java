package com.cn.web;

import com.cn.result.Result;
import com.cn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author nchen
 * @Date 2021/10/18 17:04
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value(value = "${server.port}")
    private String serverPort;


    /**http://localhost:5001/payment/ok/1*/
    @RequestMapping("ok/{id}")
    public Result ok(@PathVariable("id") Integer id) {
        return  paymentService.paymentInfo_ok(id);
    }

    /**http://localhost:5001/payment/timeout/1*/
    @RequestMapping("timeout/{id}")
    public Result timeout(@PathVariable("id") Integer id) {
        return  paymentService.paymentInfo_timeout(id);
    }

    /**
     * 熔断机制
     * http://localhost:5001/payment/circuitBreaker/1
     *
     */
    @RequestMapping("circuitBreaker/{id}")
    Result paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }

}
