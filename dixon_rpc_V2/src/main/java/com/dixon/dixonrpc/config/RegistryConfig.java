package com.dixon.dixonrpc.config;

import com.dixon.dixonrpc.registry.RegistryKeys;
import lombok.Data;

/**
 * @Author:PanYa
 * @Date 2024/6/28-下午2:51
 * @Description:
 */
@Data
public class RegistryConfig {
    /**
     * 注册中心类别
     */
    private String registry = RegistryKeys.ETCD;

    /**
     * 注册中心地址
     */
    private String address = "http://localhost:2380";

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 超时时间（单位毫秒）
     */
    private Long timeout = 10000L;
}
