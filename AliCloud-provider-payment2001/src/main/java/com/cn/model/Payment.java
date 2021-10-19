package com.cn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author nchen
 * @Date 2021/5/26 14:07
 * @Version 1.0
 * @Description
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

}
