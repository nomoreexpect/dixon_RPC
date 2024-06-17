package com.dixon.example.provider;

import com.dixon.dixonrpc.registry.LocalRegistry;
import com.dixon.dixonrpc.server.HttpServer;
import com.dixon.dixonrpc.server.VertxHttpServer;
import com.dixon.example.commpn.server.UserService;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午9:03
 * @Description: 服务提供者启动类EasyProviderExample，之后会在该类的main方法中编写提供服务的代码
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        //提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);

    }
}
