package com.dixon.dixonrpc.config;

import com.dixon.dixonrpc.fault.retry.RetryStrategy;
import com.dixon.dixonrpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @Author:PanYa
 * @Date 2024/7/3-下午11:42
 * @Description:
 */
@Slf4j
public class NoRetryStrategy implements RetryStrategy {

    @Override
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {
        return callable.call();
    }
}
