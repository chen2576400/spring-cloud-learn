package com.cn.service;


import com.baomidou.mybatisplus.service.IService;
import com.cn.model.User;
import com.cn.model.UserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chen
 * @since 2021-02-02
 */

public interface UserService extends IService<User> {
    List<User> findAllUser();

    List<UserVo>  findUserAndCardByID(Integer userID);
}
