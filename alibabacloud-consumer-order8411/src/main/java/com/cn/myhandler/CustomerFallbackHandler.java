package com.cn.myhandler;

import com.cn.result.Result;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author nchen
 * @Date 2021/11/6 16:11
 * @Version 1.0
 * @Description
 */
public class CustomerFallbackHandler {
    //如果是引用的class+name双属性  此方法静态的才生效
    public static Result handleFallback1(@PathVariable("id") Integer id, Throwable throwable) {
        return Result.error("兜底方法异常handleFallback------1");
    }

}

