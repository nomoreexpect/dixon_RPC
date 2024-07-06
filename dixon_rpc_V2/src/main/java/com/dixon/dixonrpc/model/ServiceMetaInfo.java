package com.dixon.dixonrpc.model;

import cn.hutool.core.util.StrUtil;
import com.dixon.dixonrpc.RpcConstant.RpcConstant;
import lombok.Data;

/**
 * @Author:PanYa
 * @Date 2024/6/28-上午11:49
 * @Description:
 */
@Data
public class ServiceMetaInfo {

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务版本号
     */
    private String serviceVersion = RpcConstant.DEFAULT_SERVICE_VERSION;

    /**
     * 服务域名
     */
    private String serviceHost;

    /**
     * 服务端口号
     */
    private Integer servicePort;

    /**
     * 服务分组（暂未实现）
     */
    private String serviceGroup = "default";


    public String getServiceKey(){
        /*
        *@Param []
        *@return java.lang.String
        *@Description: 获取服务键名
        */
        return String.format("%s:%s", serviceName, serviceVersion);
    }

    public String getServiceNodeKey(){
        /*
        *@Param []
        *@return java.lang.String
        *@Description: 获取服务注册节点键名
        */
        return String.format("%s/%s:%s", getServiceKey(), serviceHost, servicePort);
    }

    public String getServiceAddress() {
        /*
        *@Param []
        *@return java.lang.String
        *@Description: 获取完整服务地址
        */
        if (!StrUtil.contains(serviceHost, "http")) {
            return String.format("http://%s:%s", serviceHost, servicePort);
        }
        return String.format("%s:%s", serviceHost, servicePort);
    }
}
