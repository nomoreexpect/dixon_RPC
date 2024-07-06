package com.dixon.dixonrpc.fault.retry;

import com.dixon.dixonrpc.config.NoRetryStrategy;
import com.dixon.dixonrpc.spi.SpiLoader;

/**
 * @Author:PanYa
 * @Date 2024/7/5-下午2:54
 * @Description:
 */
public class RetryStrategyFactory {
    static {
        SpiLoader.load(RetryStrategy.class);
    }

    private static final RetryStrategy DEFAULT_RETRY_STRATEGY = new NoRetryStrategy();

    public static RetryStrategy getInstance(String key){
        return SpiLoader.getInstance(RetryStrategy.class, key);
    }
}
