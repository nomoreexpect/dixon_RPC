package com.dixon.dixonrpc.server;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午9:38
 * @Description:
 */
public interface HttpServer {
    /*
    *@Param [port]
    *@return void
    *@Description: 启动服务类
    */
    void doStart(int port);
}
