package com.dixon.dixonrpc.loadbalancer;

/**
 * @Author:PanYa
 * @Date 2024/7/3-下午10:50
 * @Description:
 */
public interface LoadBalancerKeys {
    String ROUND_ROBIN = "roundRobin";

    String RANDOM = "random";

    String CONSISTENT_HASH = "consistentHash";
}
