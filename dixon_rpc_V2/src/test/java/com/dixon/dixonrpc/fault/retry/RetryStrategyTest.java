package com.dixon.dixonrpc.fault.retry;

import com.dixon.dixonrpc.config.NoRetryStrategy;
import com.dixon.dixonrpc.model.RpcRequest;
import com.dixon.dixonrpc.model.RpcResponse;
import org.junit.Test;

/**
 * @Author:PanYa
 * @Date 2024/7/3-下午11:53
 * @Description:
 */
public class RetryStrategyTest {
    RetryStrategy retryStrategy = new NoRetryStrategy();

    @Test
    public void doRetry() {
        try {
            RpcResponse rpcResponse = retryStrategy.doRetry(() ->{
                System.out.println("测试重试");
                throw new RuntimeException("模拟重试失败");
            });
            System.out.println(rpcResponse);
        }catch (Exception e) {
            System.out.println("重试多次失败");
            e.printStackTrace();
        }
    }
}
