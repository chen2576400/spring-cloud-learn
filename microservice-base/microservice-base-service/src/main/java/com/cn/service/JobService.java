package com.cn.service;

import com.cn.model.Job;

import java.util.List;

/**
 * @Author nchen
 * @Date 2021/5/26 14:33
 * @Version 1.0
 * @Description
 */
public interface JobService {

    List<Job>  findAllJob();
}
