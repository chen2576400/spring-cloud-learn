package com.cn.web;



import com.cn.model.User;
import com.cn.model.UserVo;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chen
 * @since 2021-02-02
 * http://localhost:8082/
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAllUser")
    public List<User> userList() {
        return userService.findAllUser();
    }

    @RequestMapping("/findAllUserByID")
    public List<UserVo> findUserAndCardByID(Integer id) {
        return userService.findUserAndCardByID(id);
    }

    @RequestMapping("/findUserAndCardByID1")
    public List<UserVo> findUserAndCardByID1(@RequestBody Integer id) {
        return userService.findUserAndCardByID(id);
    }
}
