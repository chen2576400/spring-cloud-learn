package com.cn.service;

import com.cn.model.Payment;

import java.util.List;

/**
 * @Author nchen
 * @Date 2021/10/18 16:52
 * @Version 1.0
 * @Description
 */
public interface PaymentService {


    Payment create(Payment payment);

    Payment getPaymentById(Long id);


    List<Payment> getPaymentList();
}
