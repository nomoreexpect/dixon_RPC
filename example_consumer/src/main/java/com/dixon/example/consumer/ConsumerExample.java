package com.dixon.example.consumer;

import cn.hutool.json.JSONUtil;
import com.dixon.dixonrpc.config.RpcConfig;
import com.dixon.dixonrpc.utils.ConfigUtils;

/**
 * @Author:PanYa
 * @Date 2024/6/18-下午2:44
 * @Description:
 */
public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
    

}
