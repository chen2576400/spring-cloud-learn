package com.cn.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cn.myhandler.CustomerBlockHandler;
import com.cn.result.Result;
import org.springframework.stereotype.Service;

/**
 * @Author nchen
 * @Date 2021/11/6 14:04
 * @Version 1.0
 * @Description
 */
@Service
public class DoSomeThingImpl implements DoSomeThing{


    //region 资源名称限流
    @Override
    @SentinelResource(value ="byResource",blockHandler = "del_testHotkey")
    public Result byResource(Integer pi, Integer p2) {
        return Result.ok("按资源名称限流测试ok");
    }
    public Result del_testHotkey(Integer p1, Integer p2, BlockException exception){
        return Result.error("--------------testC   Hotkey,o(╥﹏╥)o");
    }
    //endregion


    //region URL限流
    @Override
    @SentinelResource(value ="byUrl")
    public Result byUrl(Integer pi, Integer p2) {
        return Result.ok("按URL限流测试ok");
    }
    //endregion


    //region 自定义处理类抽出来
    @Override
    @SentinelResource(value ="customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class ,
            blockHandler = "handlerException2")
    public Result customerBlockHandler() {
        return Result.ok("按用户自定义");
    }
    //endregion
}
