package com.cn.mapper;

import com.cn.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author nchen
 * @Date 2021/5/26 14:10
 * @Version 1.0
 * @Description
 */
public interface  JobDao extends JpaRepository<Job, Long> {

}
