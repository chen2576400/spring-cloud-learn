package com.cn.web;

import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nchen
 * @Date 2021/10/29 9:54
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("config")
@RefreshScope //支持nacos动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;


    /**http://localhost:3377/config/info*/
    @RequestMapping("info")
    public Result getConfigInfo(){
        return Result.ok(configInfo);
    }
}
