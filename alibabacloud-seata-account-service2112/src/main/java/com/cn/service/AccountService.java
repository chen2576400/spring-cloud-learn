package com.cn.service;

/**
 * @Author nchen
 * @Date 2021/12/10 15:53
 * @Version 1.0
 * @Description
 */

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public  interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
