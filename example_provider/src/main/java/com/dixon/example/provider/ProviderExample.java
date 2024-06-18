package com.dixon.example.provider;

import com.dixon.dixonrpc.RpcApplication;
import com.dixon.dixonrpc.registry.LocalRegistry;
import com.dixon.dixonrpc.server.HttpServer;
import com.dixon.dixonrpc.server.VertxHttpServer;
import com.dixon.example.commpn.server.UserService;

/**
 * @Author: PanYa
 * @Date 2024/6/18-下午2:48
 * @Description: 服务提供者示例
 */
public class ProviderExample {
    public static void main(String[] args) {

        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
