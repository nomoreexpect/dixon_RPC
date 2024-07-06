package com.dixon.dixonrpc.fault.tolerant;

/**
 * @Author:PanYa
 * @Date 2024/7/5-下午3:40
 * @Description:
 */
public interface TolerantStrategyKeys {
    /**
     * 故障恢复
     */
    String FAIL_BACK = "failBack";

    /**
     * 快速失败
     */
    String FAIL_FAST = "failFast";

    /**
     * 故障转移
     */
    String FAIL_OVER = "failOver";

    /**
     * 静默处理
     */
    String FAIL_SAFE = "failSafe";

}
