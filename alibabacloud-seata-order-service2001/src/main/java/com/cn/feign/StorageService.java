package com.cn.feign;

import com.cn.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author nchen
 * @Date 2021/12/9 17:10
 * @Version 1.0
 * @Description
 */

@FeignClient("alibabacloud-seata-storage-service2111")
public interface StorageService {

    @RequestMapping(value = "/storage/decrease")
    Result decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);


}