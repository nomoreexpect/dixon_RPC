package com.dixon.dixonrpc.fault.tolerant;

import com.dixon.dixonrpc.spi.SpiLoader;

/**
 * @Author:PanYa
 * @Date 2024/7/5-下午3:41
 * @Description:
 */
public class TolerantStrategyFactory {
    static {
        SpiLoader.load(TolerantStrategy.class);
    }

    private static final TolerantStrategy DEFAULT_RETRY_STRATEGY = new FailFastTolerantStrategy();

    public static TolerantStrategy getInstance(String key){
        return SpiLoader.getInstance(TolerantStrategy.class, key);
    }
}
