package com.cn.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.mapper.UserMapper;
import com.cn.model.User;
import com.cn.model.UserVo;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-02-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.selectList(null);
    }

    @Override
    public List<UserVo> findUserAndCardByID(Integer userID) {
        return userMapper.findUserAndCardByID(userID);
    }
}
