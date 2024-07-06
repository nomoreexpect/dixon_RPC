package com.dixon.dixonrpc.fault.retry;

import com.dixon.dixonrpc.model.RpcResponse;

import java.util.concurrent.Callable;

public interface RetryStrategy {
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;
}
