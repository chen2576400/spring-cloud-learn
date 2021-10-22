package com.cn.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nchen
 * @Date 2021/10/22 15:02
 * @Version 1.0
 * @Description
 */
@RestController
@RefreshScope//刷新功能  不加这个3344配置文件修改后 3355不会读取最新的
public class ConfigClientController {
    /**
     * http://localhost:3355/test/config/info
     * 这里取的值是从文件上取回来的  文件上面有chen.info
     */
    @Value("${chen.info}")
    private String configInfo;

    @RequestMapping("/test/config/info")
    public String test(){
        return configInfo;
    }
}
