package com.dixon.example.commpn.server;

import com.dixon.example.commpn.model.User;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午9:17
 * @Description: 用户服务
 */
public interface UserService {
    /*
    *@Param [user]
    *@return com.dixon.example.commpn.model.User
    *@Description: 获取用户
    */
    User getUser(User user);

    /**
     * 用于测试 mock 接口返回值
     * 获取数字 1
     * @return
     */
    default short getNumber() {
        return 1;
    }
}
