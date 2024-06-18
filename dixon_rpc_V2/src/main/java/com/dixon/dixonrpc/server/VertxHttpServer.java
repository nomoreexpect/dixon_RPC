package com.dixon.dixonrpc.server;

import io.vertx.core.Vertx;

/**
 * @Author:PanYa
 * @Date 2024/6/17-下午9:39
 * @Description:
 */
public class VertxHttpServer implements HttpServer {

    @Override
    public void doStart(int port) {
        // 创建 Vert.x 实例
        Vertx vertx = Vertx.vertx();

        // 创建 HTTP 服务器
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        // 监听端口并处理请求
//        server.requestHandler(new HttpServerHandler());
        server.requestHandler(request -> {
           //处理Http请求
            System.out.println("Received request: " + request.method() + " " + request.uri());

            //发送Http响应
            request.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello World from Vert.x HTTP Server");
        });

        // 启动 HTTP 服务器并监听指定端口
        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server is now listening on port " + port);
            } else {
                System.err.println("Failed to start server: " + result.cause());
            }
        });
    }
}
