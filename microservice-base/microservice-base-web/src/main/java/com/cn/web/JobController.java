package com.cn.web;

import com.cn.model.Job;
import com.cn.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author nchen
 * @Date 2021/5/26 14:38
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;


    @RequestMapping("/findAllJob")
    public List<Job> userList() {
        return jobService.findAllJob();
    }

}
