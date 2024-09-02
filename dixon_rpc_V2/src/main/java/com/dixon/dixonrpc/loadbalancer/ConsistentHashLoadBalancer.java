package com.dixon.dixonrpc.loadbalancer;

import com.dixon.dixonrpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: PanYa
 * @Date 2024/7/3-下午10:42
 * @Description:
 */
public class ConsistentHashLoadBalancer implements LoadBalancer {

    private final TreeMap<Integer, ServiceMetaInfo> virtualNodes = new TreeMap<>();

    private static final int VIRTUAL_NODE_NUM = 100;

    @Override
    public ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList) {
        if(serviceMetaInfoList.isEmpty()){
            return null;
        }

        for(ServiceMetaInfo serviceMetaInfo : serviceMetaInfoList){
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                int hash = getHash(serviceMetaInfo.getServiceAddress() + "#" + i);
                virtualNodes.put(hash, serviceMetaInfo);
            }
        }
        int hash = getHash(requestParams);

        Map.Entry<Integer, ServiceMetaInfo> entry = virtualNodes.ceilingEntry(hash);
        if(entry == null){
            entry = virtualNodes.firstEntry();
        }
        return entry.getValue();
    }

//    private int getHash(Object obj){
//        return obj.hashCode();
//    }
private int getHash(Object obj) {
    // 将对象转换为字符串，或者根据对象的属性来计算哈希值
    String objAsString = obj.toString();

    int hash = 0;
    for (int i = 0; i < objAsString.length(); i++) {
        hash = 31 * hash + objAsString.charAt(i); // 31 是一个常用的哈希乘数
    }

    return hash;
}

}
