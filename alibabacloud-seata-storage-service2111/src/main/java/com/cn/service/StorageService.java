package com.cn.service;

/**
 * @Author nchen
 * @Date 2021/12/10 15:33
 * @Version 1.0
 * @Description
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
