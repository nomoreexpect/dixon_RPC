package com.dixon.example.consumer;

import cn.hutool.json.JSONUtil;
import com.dixon.dixonrpc.bootstrap.ConsumerBootstrap;
import com.dixon.dixonrpc.config.RpcConfig;
import com.dixon.dixonrpc.proxy.ServiceProxyFactory;
import com.dixon.dixonrpc.utils.ConfigUtils;
import com.dixon.example.commpn.model.User;
import com.dixon.example.commpn.server.UserService;

/**
 * @Author:PanYa
 * @Date 2024/6/18-下午2:44
 * @Description:
 */
public class ConsumerExample {
    public static void main(String[] args) {
//        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
//        System.out.println(rpc);
        //服务提供者初始化
        ConsumerBootstrap.init();
        //获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("dixon");

        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        }else {
            System.out.println("user == null! ");
        }
//        long number = userService.getNumber();
//        System.out.println(number);
    }
    

}
