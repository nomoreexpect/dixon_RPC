package com.dixon.dixonrpc.loadbalancer;

import com.dixon.dixonrpc.spi.SpiLoader;

/**
 * @Author:PanYa
 * @Date 2024/7/3-下午10:51
 * @Description:
 */
public class LoadBalancerFactory {
    static {
        SpiLoader.load(LoadBalancer.class);
    }

    private static final LoadBalancer DEFAULT_LOAD_BALANCER = new RandomLoadBalancer();
    public static LoadBalancer getInstance(String key){
        return SpiLoader.getInstance(LoadBalancer.class, key);
    }
}
