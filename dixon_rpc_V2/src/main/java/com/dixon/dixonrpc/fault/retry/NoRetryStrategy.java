package com.dixon.dixonrpc.fault.retry;

import com.dixon.dixonrpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @Author:PanYa
 * @Date 2024/7/8-下午7:42
 * @Description:
 */
@Slf4j
public class NoRetryStrategy implements RetryStrategy {

    @Override
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {
        return callable.call();
    }
}
