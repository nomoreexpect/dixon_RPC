package com.dixon.dixonrpc.registry;

import com.dixon.dixonrpc.config.RegistryConfig;
import com.dixon.dixonrpc.model.ServiceMetaInfo;

import java.util.List;


public interface Registry {
    //初始化
    void init(RegistryConfig registryConfig);

    //注册服务（服务端）
    void register(ServiceMetaInfo serviceMetaInfo) throws Exception;

    //注销服务（服务端）
    void unRegister(ServiceMetaInfo serviceMetaInfo);

    //服务发现（获取某服务的所有节点，消费端）
    List<ServiceMetaInfo> serviceDiscovery(String serviceKey);

    /**
     * 心跳检测（服务端）
     */
    void heartBeat();

    /**
     * 监听（消费端）
     */
    void watch(String serviceNodeKey);

    /**
     * 服务销毁
     */
    void destroy();
}
