package com.cn.service;

import com.cn.result.Result;
import org.springframework.stereotype.Component;

/**
 * @Author nchen
 * @Date 2021/10/21 15:39
 * @Version 1.0
 * @Description
 */
@Component
public class PaymentHystrixFeignFallbackServiceImpl implements PaymentHystrixFeignService{
    @Override
    public Result ok(Integer id) {
        return Result.ok("Fegin-Hystrix响应处理接口ok-------o(╥﹏╥)o");
    }

    @Override
    public Result timeout(Integer id) {
        return Result.ok("Fegin-Hystrix响应处理接口timeout-------超时o(╥﹏╥)o");
    }
}
