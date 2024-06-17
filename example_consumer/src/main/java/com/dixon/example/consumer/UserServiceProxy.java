package com.dixon.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.dixon.dixonrpc.model.RpcRequest;
import com.dixon.dixonrpc.model.RpcResponse;
import com.dixon.dixonrpc.serializer.Serializer;
import com.dixon.dixonrpc.serializer.JdkSerializer;
import com.dixon.example.commpn.model.User;
import com.dixon.example.commpn.server.UserService;


import java.io.IOException;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午10:16
 * @Description:
 */
public class UserServiceProxy implements UserService {
    public User getUser(User user) {
        // 指定序列化器
        final Serializer serializer = new JdkSerializer();

        // 构造请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            // 序列化（Java 对象 => 字节数组）
            byte[] bodyBytes = serializer.serialize(rpcRequest);

            // 发送请求
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                byte[] result = httpResponse.bodyBytes();
                // 反序列化（字节数组 => Java 对象）
                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
                return (User) rpcResponse.getData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
