package com.cn.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author nchen
 * @Date 2021/5/26 14:07
 * @Version 1.0
 * @Description
 */
@Entity
@Table
@Data
public class Job {

    @Id
    private Long id;

    @Column(length = 32)
    private String name;

    @Column(length = 32)
    private String description;

}
