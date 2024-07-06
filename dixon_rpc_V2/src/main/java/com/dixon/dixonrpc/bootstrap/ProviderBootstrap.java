package com.dixon.dixonrpc.bootstrap;

import com.dixon.dixonrpc.RpcApplication;
import com.dixon.dixonrpc.config.RegistryConfig;
import com.dixon.dixonrpc.config.RpcConfig;
import com.dixon.dixonrpc.model.ServiceMetaInfo;
import com.dixon.dixonrpc.model.ServiceRegisterInfo;
import com.dixon.dixonrpc.registry.LocalRegistry;
import com.dixon.dixonrpc.registry.Registry;
import com.dixon.dixonrpc.registry.RegistryFactory;
import com.dixon.dixonrpc.server.tcp.VertxTcpServer;

import java.util.List;

/**
 * @Author:PanYa
 * @Date 2024/7/6-下午4:38
 * @Description:
 */
public class ProviderBootstrap {

    /**
     * 初始化
     */
    public static void init(List<ServiceRegisterInfo<?>> serviceRegisterInfoList) {
        //Rpc 框架初始化
        RpcApplication.init();
        //全局配置
        final RpcConfig rpcConfig = RpcApplication.getRpcConfig();

        //注册服务
        for (ServiceRegisterInfo<?> serviceRegisterInfo:serviceRegisterInfoList){
            String serviceName = serviceRegisterInfo.getServiceName();
            //本地注册
            LocalRegistry.register(serviceName,serviceRegisterInfo.getImplClass());

            // 注册服务到注册中心
            RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
            Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
            serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
            try {
                registry.register(serviceMetaInfo);
            } catch (Exception e) {
                throw new RuntimeException(serviceName + " 服务注册失败", e);
            }
        }

        // 启动服务器
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(rpcConfig.getServerPort());
        }
}

