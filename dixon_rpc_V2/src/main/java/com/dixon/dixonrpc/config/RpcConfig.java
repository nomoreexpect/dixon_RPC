package com.dixon.dixonrpc.config;

import com.dixon.dixonrpc.fault.retry.RetryStrategyKeys;
import com.dixon.dixonrpc.loadbalancer.LoadBalancerKeys;
import com.dixon.dixonrpc.serializer.SerializerKeys;
import com.dixon.dixonrpc.fault.tolerant.TolerantStrategyKeys;
import lombok.Data;


/**
 * @Author: PanYa
 * @Date 2024/6/18-下午2:16
 * @Description: RPC 框架全局配置
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "dixon_rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 负载均衡器
     */
    private String loadBalancer = LoadBalancerKeys.ROUND_ROBIN;

    /**
     * 重试策略
     */
    private String retryStrategy = RetryStrategyKeys.NO;

    /**
     * 容错策略
     */
    private String tolerantStrategy = TolerantStrategyKeys.FAIL_BACK;

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();
}
