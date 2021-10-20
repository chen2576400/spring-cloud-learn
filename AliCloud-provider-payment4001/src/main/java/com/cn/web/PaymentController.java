package com.cn.web;

import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * @Author nchen
 * @Date 2021/10/18 17:04
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("zk")
public class PaymentController {

    @Value(value = "${server.port}")
    private String serverPort;



    /**http://localhost:4000/zk/payment*/
    @RequestMapping("payment")
    public Result zk(){
        return Result.ok("spring cloud with zookeeper"+serverPort + UUID.randomUUID().toString());
    }
}
