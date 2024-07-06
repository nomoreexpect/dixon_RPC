package com.dixon.dixonrpc.fault.tolerant;

import com.dixon.dixonrpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Author:PanYa
 * @Date 2024/7/5-下午3:37
 * @Description: 服务降级
 */
@Slf4j
public class FailBackTolerantStrategy implements TolerantStrategy{
    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        return null;
    }
}
