package com.cn.web;

import com.cn.model.Payment;
import com.cn.result.Result;
import com.cn.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**http://localhost:2001/payment/creat*/
    @PostMapping("creat")
    public Result create(Payment payment) {
        return Result.ok(paymentService.create(payment));
    }

    /**http://localhost:2001/payment/get/1*/
    @GetMapping("get/{id}")
    public Result create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return Result.ok(payment);
    }


    /**http://localhost:2001/payment/getAll*/
    @GetMapping("getAll")
    public Result create() {
        List<Payment> paymentList = paymentService.getPaymentList();
        return Result.ok(paymentList);
    }
}
