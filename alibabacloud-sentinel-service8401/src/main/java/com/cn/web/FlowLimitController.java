package com.cn.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cn.result.Result;
import com.cn.service.DoSomeThing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nchen
 * @Date 2021/10/28 16:49
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/sentinel")
public class FlowLimitController {
    @Autowired
    private DoSomeThing doSomeThing;

    @RequestMapping("/testA")
    public  Result testA(){
        return Result.ok("--------------testA");
    }

    @RequestMapping("/testB")
    public  Result testB(){
        return Result.ok("--------------testB");
    }


}
