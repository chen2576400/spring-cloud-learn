package com.cn.service.Impl;

import com.cn.mapper.JobDao;
import com.cn.model.Job;
import com.cn.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author nchen
 * @Date 2021/5/26 14:33
 * @Version 1.0
 * @Description
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao dao;

    @Override
    public List<Job> findAllJob() {
        return dao.findAll();
    }
}
