package com.dixon.dixonrpc.proxy;

import com.dixon.dixonrpc.RpcApplication;

import java.lang.reflect.Proxy;

/**
 * @Author: PanYa
 * @Date 2024/6/17-下午10:21
 * @Description:
 */
public class ServiceProxyFactory {
    public static <T> T getProxy(Class<T> serviceClass) {
        /*
        *@Param [serviceClass]
        *@return T
        *@Description:  根据服务类获取代理对象
        */
        if (RpcApplication.getRpcConfig().isMock()){
            return getMockProxy(serviceClass);
        }
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }

    public static <T> T getMockProxy(Class<T> serviceClass) {
        /*
        *@Param [serviceClass]
        *@return T
        *@Description: 根据服务类获取 Mock 代理对象
        */
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new MockServiceProxy());
    }
}
