package com.dixon.dixonrpc.fault.tolerant;


import com.dixon.dixonrpc.model.RpcResponse;

import java.util.Map;

public interface TolerantStrategy {
    RpcResponse doTolerant(Map<String,Object> context, Exception e);
}
