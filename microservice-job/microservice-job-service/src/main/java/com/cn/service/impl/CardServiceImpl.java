package com.cn.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.mapper.CardMapper;
import com.cn.model.Card;
import com.cn.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-02-03
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {
    @Autowired
    CardMapper mapper;

    @Override
    public List<Card> findAllCard() {
        return mapper.selectList(null);
    }
}
