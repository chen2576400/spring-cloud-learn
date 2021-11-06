package com.cn.service;

import com.cn.result.Result;

/**
 * @Author nchen
 * @Date 2021/11/6 14:04
 * @Version 1.0
 * @Description
 */
public interface DoSomeThing {

    Result byResource(Integer pi,Integer p2);
    Result byUrl(Integer pi,Integer p2);

    Result customerBlockHandler();
}
