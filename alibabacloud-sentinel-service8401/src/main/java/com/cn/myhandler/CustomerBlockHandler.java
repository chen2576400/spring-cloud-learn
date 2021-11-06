package com.cn.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cn.result.Result;

/**
 * @Author nchen
 * @Date 2021/11/6 14:57
 * @Version 1.0
 * @Description
 */
public class CustomerBlockHandler {

    public  static Result handlerException1(BlockException exception){
        return Result.error("按用户自定义,global handlerException-----1");
    }

    public  static Result handlerException2(BlockException exception){
        return Result.error("按用户自定义,global handlerException-----2");
    }
}
