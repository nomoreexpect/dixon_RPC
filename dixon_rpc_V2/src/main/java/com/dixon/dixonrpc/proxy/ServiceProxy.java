package com.dixon.dixonrpc.proxy;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.dixon.dixonrpc.RpcApplication;
import com.dixon.dixonrpc.RpcConstant.RpcConstant;
import com.dixon.dixonrpc.config.RpcConfig;
import com.dixon.dixonrpc.fault.retry.RetryStrategy;
import com.dixon.dixonrpc.fault.retry.RetryStrategyFactory;
import com.dixon.dixonrpc.fault.tolerant.TolerantStrategy;
import com.dixon.dixonrpc.fault.tolerant.TolerantStrategyFactory;
import com.dixon.dixonrpc.loadbalancer.LoadBalancer;
import com.dixon.dixonrpc.loadbalancer.LoadBalancerFactory;
import com.dixon.dixonrpc.model.RpcRequest;
import com.dixon.dixonrpc.model.RpcResponse;
import com.dixon.dixonrpc.model.ServiceMetaInfo;
import com.dixon.dixonrpc.registry.Registry;
//import com.dixon.dixonrpc.registry.RegistryFactory;
import com.dixon.dixonrpc.registry.RegistryFactory;
import com.dixon.dixonrpc.serializer.JdkSerializer;
import com.dixon.dixonrpc.serializer.Serializer;
import com.dixon.dixonrpc.serializer.SerializerFactory;
import com.dixon.dixonrpc.server.tcp.VertxTcpClient;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午10:21
 * @Description:
 */
public class ServiceProxy implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 指定序列化器
//        Serializer serializer = new JdkSerializer();
        final Serializer serializer = SerializerFactory.getInstance(RpcApplication.getRpcConfig().getSerializer());
        String serviceName = method.getDeclaringClass().getName();
        // 构造请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameterTypes(method.getParameterTypes())
                .args(args)
                .build();
            // 序列化
            //byte[] bodyBytes = serializer.serialize(rpcRequest);

            RpcConfig rpcConfig = RpcApplication.getRpcConfig();

            Registry registry = RegistryFactory.getInstance(rpcConfig.getRegistryConfig().getRegistry());

            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceVersion(RpcConstant.DEFAULT_SERVICE_VERSION);
            List<ServiceMetaInfo> serviceMetaInfoList = registry.serviceDiscovery(serviceMetaInfo.getServiceKey());
            if (CollUtil.isEmpty(serviceMetaInfoList)) {
                throw new RuntimeException("暂无服务地址");
            }
            // 负载均衡
            LoadBalancer loadBalancer = LoadBalancerFactory.getInstance(rpcConfig.getLoadBalancer());

            Map<String, Object> requestParams = new HashMap<>();
            requestParams.put("methodName", rpcRequest.getMethodName());
            ServiceMetaInfo selectedServiceMetaInfo = loadBalancer.select(requestParams, serviceMetaInfoList);
            //ServiceMetaInfo selectServiceMetaInfo = serviceMetaInfoList.get(0);
            // 发送请求
//            try (HttpResponse httpResponse = HttpRequest.post(selectServiceMetaInfo.getServiceAddress())
//                    .body(bodyBytes)
//                    .execute()) {
//                byte[] result = httpResponse.bodyBytes();
//                // 反序列化
//                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
//                return rpcResponse.getData();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }return null;

            //rpc请求
            //RpcResponse rpcResponse = VertxTcpClient.doRequest(rpcRequest,serviceMetaInfo);
//            return rpcResponse.getData();
//        }catch (Exception e){
//            throw new RuntimeException("调用失败");
//        }
            //使用重试机制
//            RetryStrategy retryStrategy = RetryStrategyFactory.getInstance(rpcConfig.getRetryStrategy());
//            RpcResponse rpcResponse = retryStrategy.doRetry(() ->
//                    VertxTcpClient.doRequest(rpcRequest, selectedServiceMetaInfo));
//            return rpcResponse.getData();
//        }catch (Exception e){
//            throw new RuntimeException("调用失败");
//        }
            RpcResponse rpcResponse;
            try {
                RetryStrategy retryStrategy = RetryStrategyFactory.getInstance(rpcConfig.getRetryStrategy());
                rpcResponse = retryStrategy.doRetry(() ->
                    VertxTcpClient.doRequest(rpcRequest, selectedServiceMetaInfo));
            } catch (Exception e) {
                TolerantStrategy tolerantStrategy = TolerantStrategyFactory.getInstance(rpcConfig.getTolerantStrategy());
                rpcResponse = tolerantStrategy.doTolerant(null,e);
            }
            return rpcResponse.getData();
        }
    }

//======================================这是一个分割线====================================================
//public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//    // 指定序列化器
//    Serializer serializer = new JdkSerializer();
//
//    // 构造请求
//    RpcRequest rpcRequest = RpcRequest.builder()
//            .serviceName(method.getDeclaringClass().getName())
//            .methodName(method.getName())
//            .parameterTypes(method.getParameterTypes())
//            .args(args)
//            .build();
//    try {
//        // 序列化
//        byte[] bodyBytes = serializer.serialize(rpcRequest);
//        // 发送请求
//        // todo 注意，这里地址被硬编码了（需要使用注册中心和服务发现机制解决）
//        try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
//                .body(bodyBytes)
//                .execute()) {
//            byte[] result = httpResponse.bodyBytes();
//            // 反序列化
//            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
//            return rpcResponse.getData();
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//    return null;
//}

