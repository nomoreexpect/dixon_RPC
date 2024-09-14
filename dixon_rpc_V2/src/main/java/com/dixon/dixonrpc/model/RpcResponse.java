package com.dixon.dixonrpc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午10:05
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RpcResponse implements Serializable {
    /**
     * 响应数据
     */
    private Object data;

    /**
     * 响应数据类型（预留）
     */
    private Class<?> dataType;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 异常信息
     */
    private Exception exception;

    /**
     * 响应状态，表示成功或降级
     */
    private String status;  // e.g., "SUCCESS", "FALLBACK", "TIMEOUT"


    /**
     * 构建降级响应 (Fallback)
     * @param message 降级消息
     * @param defaultData 默认的数据
     * @return 构建的降级响应对象
     */
    public static RpcResponse buildFallbackResponse(String message, Object defaultData) {
        return RpcResponse.builder()
                .data(defaultData)
                .dataType(defaultData != null ? defaultData.getClass() : null)
                .message(message)
                .status("FALLBACK")
                .build();
    }

    /**
     * 构建异常响应
     * @param exception 异常
     * @param message 错误消息
     * @return 构建的异常响应对象
     */
    public static RpcResponse buildErrorResponse(Exception exception, String message) {
        return RpcResponse.builder()
                .exception(exception)
                .message(message)
                .status("ERROR")
                .build();
    }
}
