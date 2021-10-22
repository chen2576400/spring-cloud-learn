package com.cn.service;

import com.cn.mapper.PaymentDao;
import com.cn.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author nchen
 * @Date 2021/10/18 16:53
 * @Version 1.0
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao dao;

    @Override
    public Payment create(Payment payment) {
        return dao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        Optional<Payment> optionalPayment = dao.findById(id);
        return optionalPayment.orElse(null);
    }

    @Override
    public List<Payment> getPaymentList() {
        return dao.findAll();
    }
}
