package com.dixon.dixonrpc.loadbalancer;

import com.dixon.dixonrpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:PanYa
 * @Date 2024/7/3-下午10:30
 * @Description:
 */
public class RoundRobinLoadBalancer implements LoadBalancer {

    private final AtomicInteger currentIndex = new AtomicInteger(0);

    public ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList) {
        if (serviceMetaInfoList.isEmpty()) {
            return null;
        }
        // 只有一个服务，无需轮询
        int size = serviceMetaInfoList.size();
        if (size == 1) {
            return serviceMetaInfoList.get(0);
        }
        // 取模算法轮询
        int index =  currentIndex.getAndIncrement() % size;
        return serviceMetaInfoList.get(index);
    }
}
