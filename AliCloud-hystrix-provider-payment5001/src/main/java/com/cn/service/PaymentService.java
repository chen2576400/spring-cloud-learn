package com.cn.service;

import com.cn.result.Result;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author nchen
 * @Date 2021/10/18 16:52
 * @Version 1.0
 * @Description
 */
public interface PaymentService {

    Result paymentInfo_ok(Integer id);



    Result paymentInfo_timeout(Integer id);


    Result paymentCircuitBreaker(Integer id);

}
