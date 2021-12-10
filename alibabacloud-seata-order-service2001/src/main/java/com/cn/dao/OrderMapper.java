package com.cn.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cn.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface OrderMapper extends BaseMapper<Order> {


}