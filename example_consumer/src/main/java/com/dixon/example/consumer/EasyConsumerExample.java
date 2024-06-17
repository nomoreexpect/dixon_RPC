package com.dixon.example.consumer;


import com.dixon.dixonrpc.proxy.ServiceProxyFactory;
import com.dixon.example.commpn.model.User;
import com.dixon.example.commpn.server.UserService;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午9:33
 * @Description: 服务消费者启动类EasyConsumerExample,编写调用接口的代码
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        // 静态代理
//        UserService userService = new UserServiceProxy();
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("dixon");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}