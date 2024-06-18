package com.dixon.dixonrpc;

import com.dixon.dixonrpc.RpcConstant.RpcConstant;
import com.dixon.dixonrpc.config.RpcConfig;
import com.dixon.dixonrpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author:PanYa
 * @Date 2024/6/18-下午2:30
 * @Description:  RPC 框架应用,相当于 holder，存放了项目全局用到的变量。双检锁单例模式实现
 */
@Slf4j
public class RpcApplication {
    private static volatile RpcConfig rpcConfig;
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}", newRpcConfig.toString());
        // 注册中心初始化
//        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
//        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
//        registry.init(registryConfig);
//        log.info("registry init, config = {}", registryConfig);
//        // 创建并注册 Shutdown Hook，JVM 退出时执行操作
//        Runtime.getRuntime().addShutdownHook(new Thread(registry::destroy));
    }

    /**
     * 初始化
     */
    public static void init() {
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            // 配置加载失败，使用默认值
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }
    //获取配置
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
