package com.cn.web;

import com.cn.model.Payment;
import com.cn.result.Result;
import com.cn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    /**http://localhost:2001/payment/creat*/
    @PostMapping("creat")
    public Result create(Payment payment) {
        return Result.ok(paymentService.create(payment));
    }

    /**http://localhost:2001/payment/get/1*/
    @GetMapping("get/{id}")
    public Result create(@PathVariable("id") Long id) {
        System.out.println("我是负责响应的服务器"+serverPort);
        Payment payment = paymentService.getPaymentById(id);
        return Result.ok(payment);
    }


    /**http://localhost:2001/payment/getAll*/
    @GetMapping("getAll")
    public Result create() {
        List<Payment> paymentList = paymentService.getPaymentList();
        return Result.ok(paymentList);
    }


    @GetMapping("lb")
    public Result getLb() {
        return Result.ok(serverPort);
    }



    @RequestMapping("paymentFeginTimeout")
    public Result  paymentFeginTimeout(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.ok("我已经设置了延迟5S，端口:"+serverPort);
    }
}
