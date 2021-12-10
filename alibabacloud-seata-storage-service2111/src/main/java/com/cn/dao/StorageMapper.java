package com.cn.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cn.model.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    //扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}