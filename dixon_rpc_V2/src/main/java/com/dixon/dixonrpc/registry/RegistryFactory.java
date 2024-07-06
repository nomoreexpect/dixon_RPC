package com.dixon.dixonrpc.registry;


import com.dixon.dixonrpc.spi.SpiLoader;

/**
 * @Author:PanYa
 * @Date 2024/6/28-下午3:48
 * @Description:
 */
public class RegistryFactory {
    // SPI 动态加载
    static {
        SpiLoader.load(Registry.class);
    }

    /**
     * 默认注册中心
     */
    private static final Registry DEFAULT_REGISTRY = new EtcdRegistry();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Registry getInstance(String key) {
        return SpiLoader.getInstance(Registry.class, key);
    }

}
