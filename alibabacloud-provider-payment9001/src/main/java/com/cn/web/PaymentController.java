package com.cn.web;

import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nchen
 * @Date 2021/10/28 16:49
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    /**http://localhost:9001/payment/nacos/1*/
    @RequestMapping("/nacos/{id}")
    public  Result getPayment(@PathVariable("id") Integer id){
        return Result.ok("nacos 9001-payment,Server Port:" + serverPort+"\t id:"+id);

    }

}
