package com.dixon.example.provider;

import com.dixon.dixonrpc.RpcApplication;
import com.dixon.dixonrpc.bootstrap.ProviderBootstrap;
import com.dixon.dixonrpc.config.RegistryConfig;
import com.dixon.dixonrpc.config.RpcConfig;
import com.dixon.dixonrpc.model.ServiceMetaInfo;
import com.dixon.dixonrpc.model.ServiceRegisterInfo;
import com.dixon.dixonrpc.registry.LocalRegistry;
import com.dixon.dixonrpc.registry.Registry;
import com.dixon.dixonrpc.registry.RegistryFactory;
import com.dixon.dixonrpc.server.HttpServer;
import com.dixon.dixonrpc.server.VertxHttpServer;
import com.dixon.example.commpn.server.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: PanYa
 * @Date 2024/6/18-下午2:48
 * @Description: 服务提供者示例
 */
public class ProviderExample {
    public static void main(String[] args) {
        // 要注册的服务
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo serviceRegisterInfo = new ServiceRegisterInfo(UserService.class.getName(),UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);
        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);
    }
//    public static void main(String[] args) {
//
//        // RPC 框架初始化
//        RpcApplication.init();
//
//        String serviceName = UserService.class.getName();
//        // 注册服务
//        LocalRegistry.register(serviceName, UserServiceImpl.class);
//
//        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
//        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
//        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
//        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
//        serviceMetaInfo.setServiceName(serviceName);
//        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
//        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
//        try {
//            registry.register(serviceMetaInfo);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//
//        // 启动 web 服务
//        HttpServer httpServer = new VertxHttpServer();
//        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
//    }
}
