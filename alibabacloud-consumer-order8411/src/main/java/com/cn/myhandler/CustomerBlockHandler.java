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
    //如果是引用的class+name双属性  此方法静态的才生效
    public  static Result handlerException1(Integer id,BlockException exception){
        return Result.error("兜底限流异常handlerException------1");
    }

}
