package com.cn.feign;

import com.cn.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author nchen
 * @Date 2021/12/9 14:59
 * @Version 1.0
 * @Description
 */
@FeignClient("alibabacloud-seata-account-service2112")
public interface AccountService {
    @RequestMapping(value = "account/decrease")
    Result decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);


}
