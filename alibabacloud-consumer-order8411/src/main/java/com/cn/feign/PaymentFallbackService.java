package com.cn.feign;

import com.cn.result.Result;
import org.springframework.stereotype.Service;

/**
 * @Author nchen
 * @Date 2021/11/15 16:00
 * @Version 1.0
 * @Description
 */
@Service
public class PaymentFallbackService implements PaymentService{
    @Override
    public Result getPayment(Integer id) {
        return Result.error("服务降级返回,-----------PaymentServiceImpl");
    }
}
