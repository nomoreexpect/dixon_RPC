package com.dixon.dixonrpc.registry;

import com.dixon.dixonrpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * @Author:PanYa
 * @Date 2024/7/2-上午11:24
 * @Description:
 */
public class RegistryServiceCache {
    //服务缓存
    List<ServiceMetaInfo> serviceCache;

    void writeCache(List<ServiceMetaInfo> serviceCache) {
        this.serviceCache = serviceCache;
    }

    List<ServiceMetaInfo> readCache() {
        return this.serviceCache;
    }

    void clearCache() {
        this.serviceCache = null;
    }
}
