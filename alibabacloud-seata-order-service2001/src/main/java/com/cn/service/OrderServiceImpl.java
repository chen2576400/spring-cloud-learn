package com.cn.service;

/**
 * @Author nchen
 * @Date 2021/12/9 14:58
 * @Version 1.0
 * @Description
 */

import com.cn.dao.OrderMapper;
import com.cn.feign.AccountService;
import com.cn.feign.StorageService;
import com.cn.model.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    AccountService accountService;
    @Autowired
    StorageService storageService;
    @Autowired
    OrderMapper orderMapper;


    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public Order createOrder(Order order) {
        order.setStatus(0);
        //新建订单
        log.info("------------>开始创建订单");
        orderMapper.insert(order);

        //扣减库存
        log.info("------------>订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------------>订单微服务开始调用库存，做扣减end");

        //扣减账户
        log.info("------------>订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------------>订单微服务开始调用账户，做扣减  end");

        //修改订单状态（从0到1表示已完成）
        log.info("------------>修改订单状态开始");
        Order updateOrder = new Order();
        updateOrder.setId(order.getId());
        updateOrder.setStatus(1);
        orderMapper.updateById(updateOrder);
        log.info("------------>修改订单状态结束");


        log.info("------------>下订单结束了，O(∩_∩)O哈哈~");

        return null;
    }
}
