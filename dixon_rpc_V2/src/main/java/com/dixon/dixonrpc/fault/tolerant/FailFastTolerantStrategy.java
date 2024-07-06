package com.dixon.dixonrpc.fault.tolerant;

import com.dixon.dixonrpc.model.RpcResponse;

import java.util.Map;

/**
 * @Author:PanYa
 * @Date 2024/7/5-下午3:32
 * @Description:
 */
public class FailFastTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        throw new RuntimeException("服务报错", e);
    }
}
