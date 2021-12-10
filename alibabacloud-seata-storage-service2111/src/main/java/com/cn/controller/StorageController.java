package com.cn.controller;

import com.cn.result.Result;
import com.cn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nchen
 * @Date 2021/12/10 15:43
 * @Version 1.0
 * @Description
 */
@RestController
public class StorageController{

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public Result decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return Result.ok("扣减库存成功");
    }

}
