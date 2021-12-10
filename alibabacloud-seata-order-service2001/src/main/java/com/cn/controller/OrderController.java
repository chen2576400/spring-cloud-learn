package com.cn.controller;

import com.cn.model.Order;
import com.cn.result.Result;
import com.cn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nchen
 * @Date 2021/12/10 14:08
 * @Version 1.0
 * @Description
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    /**http://localhost:2001/order/creat?userId=1&productId=1&count=10&money=100*/
    @RequestMapping("/order/creat")
    public Result create(Order order){
        orderService.createOrder(order);
        return  Result.ok("订单创建成功");
    }

}
