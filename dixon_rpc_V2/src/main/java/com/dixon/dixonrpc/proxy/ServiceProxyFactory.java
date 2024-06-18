package com.dixon.dixonrpc.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午10:21
 * @Description:
 */
public class ServiceProxyFactory {
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
