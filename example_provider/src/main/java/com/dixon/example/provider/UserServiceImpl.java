package com.dixon.example.provider;

import com.dixon.example.commpn.model.User;
import com.dixon.example.commpn.server.UserService;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午9:03
 * @Description: 服务实现嘞，实现公共模块种定义的用户服务接口
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名: " + user.getName());
        return user;
    }
}
