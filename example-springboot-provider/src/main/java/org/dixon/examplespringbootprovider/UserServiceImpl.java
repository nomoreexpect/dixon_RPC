package org.dixon.examplespringbootprovider;

import com.dixon.example.commpn.model.User;
import com.dixon.example.commpn.server.UserService;
import org.dixon.dixonrpc.springboot.starter.annotation.RpcService;
import org.springframework.stereotype.Service;

/**
 * @Author:PanYa
 * @Date 2024/7/6-下午7:07
 * @Description:
 */
@Service
@RpcService
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(User user) {
        System.out.println("用户名： " + user.getName());
        return user;
    }
}
