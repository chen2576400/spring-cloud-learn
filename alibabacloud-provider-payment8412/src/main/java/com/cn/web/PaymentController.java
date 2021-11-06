package com.cn.web;

import com.cn.result.Payment;
import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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


    public static HashMap<Integer, Payment> hashMap = new HashMap();
    static {
        hashMap.put(1,new Payment(1L,"11111111111"));
        hashMap.put(2,new Payment(2L,"22222222222"));
        hashMap.put(3,new Payment(3L,"33333333333"));
    }


    /**http://localhost:8412/payment/paymentSQL/1*/
    @RequestMapping("/paymentSQL/{id}")
    public  Result getPayment(@PathVariable("id") Integer id){
        Payment payment = hashMap.get(id);
        return Result.ok(payment,"端口号为:"+serverPort);
    }
}
