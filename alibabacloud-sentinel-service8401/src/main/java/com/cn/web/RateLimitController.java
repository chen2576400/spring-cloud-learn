package com.cn.web;

import com.cn.result.Result;
import com.cn.service.DoSomeThing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nchen
 * @Date 2021/11/6 14:35
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/sentinel")
public class RateLimitController {
    @Autowired
    private DoSomeThing doSomeThing;

    /**http://127.0.0.1:8401/sentinel/byResource*/
    @RequestMapping("/byResource")
    public Result byResource(@RequestParam(value = "p1" ,required = false)Integer p1,
                        @RequestParam(value = "p2" ,required = false)Integer p2){
        return doSomeThing.byResource(p1, p2);
    }


    /**http://127.0.0.1:8401/sentinel/byUrl*/
    @RequestMapping("/byUrl")
    public Result byUrl(@RequestParam(value = "p1" ,required = false)Integer p1,
                        @RequestParam(value = "p2" ,required = false)Integer p2){
        return doSomeThing.byUrl(p1, p2);
    }



    /**http://127.0.0.1:8401/sentinel/customerBlockHandler*/
    @RequestMapping("/customerBlockHandler")
    public Result customerBlockHandler(){
        return doSomeThing.customerBlockHandler();
    }
}
