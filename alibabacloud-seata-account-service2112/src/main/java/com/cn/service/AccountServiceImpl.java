package com.cn.service;

import com.cn.dao.AccountMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author nchen
 * @Date 2021/12/10 15:54
 * @Version 1.0
 * @Description
 */
@Log4j2
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");

        //模拟超时异常，全局事务回滚(OpenFeign的调用默认时间是1s以内，所以最后会抛异常。)
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        accountMapper.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
