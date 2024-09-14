package com.dixon.dixonrpc.fault.tolerant;

import com.dixon.dixonrpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author:PanYa
 * @Date 2024/7/5-下午3:37
 * @Description: 服务降级
 */
@Slf4j
public class FailBackTolerantStrategy implements TolerantStrategy{
    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        log.error("服务调用失败，进入降级策略: {}", e.getMessage(), e);

        // 根据异常类型或业务逻辑返回降级后的响应
        RpcResponse fallbackResponse = new RpcResponse();

        if (e instanceof TimeoutException) {
            // 超时异常处理，返回一个超时提示
            fallbackResponse.setMessage("服务调用超时，返回默认响应");
            fallbackResponse.setStatus("TIMEOUT");
        }  else {
            // 默认降级处理
            fallbackResponse.setMessage("服务不可用，已降级处理");
            fallbackResponse.setStatus("FAILBACK");
        }

        // 返回降级后的响应
        return fallbackResponse;
    }

}
//else if (e instanceof NetworkException) {
//        // 网络异常处理，返回网络故障提示
//        fallbackResponse.setMessage("网络异常，无法访问服务");
//            fallbackResponse.setStatus("NETWORK_ERROR");
//        }