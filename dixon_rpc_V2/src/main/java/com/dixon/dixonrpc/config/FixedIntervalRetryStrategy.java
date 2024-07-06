package com.dixon.dixonrpc.config;

import com.dixon.dixonrpc.fault.retry.RetryStrategy;
import com.dixon.dixonrpc.model.RpcResponse;
import com.github.rholder.retry.*;
import com.sun.net.httpserver.Authenticator;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @Author:PanYa
 * @Date 2024/7/3-下午11:47
 * @Description:
 */
@Slf4j
public class FixedIntervalRetryStrategy implements RetryStrategy {
    @Override
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {
        Retryer<RpcResponse> retryer = RetryerBuilder.<RpcResponse>newBuilder()
                .retryIfExceptionOfType(Exception.class)
                .withWaitStrategy(WaitStrategies.fixedWait(3L, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withRetryListener(new RetryListener() {
                    @Override
                    public <V> void onRetry(Attempt<V> attempt) {
                        log.info("重试次数{}", attempt.getAttemptNumber());
                    }
                })
                .build();
        return retryer.call(callable);

    }
}
