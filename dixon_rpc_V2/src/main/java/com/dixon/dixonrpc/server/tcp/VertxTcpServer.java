package com.dixon.dixonrpc.server.tcp;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author:PanYa
 * @Date 2024/7/3-上午10:16
 * @Description:
 */
@Slf4j
public class VertxTcpServer {
//    private byte[] handleRequest(byte[] requestData) {
//        return "fuck, client".getBytes();
//    }

    public void doStart(int port) {
        Vertx vertx = Vertx.vertx();

        NetServer server = vertx.createNetServer();

//        server.connectHandler(socket -> {
//            socket.handler(buffer -> {
//                byte[] requestData = buffer.getBytes();
//
//                byte[] responseData = handleRequest(requestData);
//
//                socket.write(Buffer.buffer(responseData));
//            });
//        });
        // 处理请求
        server.connectHandler(new TcpServerHandler());

        server.listen(port,result -> {
            if (result.succeeded()) {
                log.info("Server started on port " + port);
            }else{
                log.info("Server failed to start on port " + port);
            }
        });
    }



    public static void main(String[] args) {
        new VertxTcpServer().doStart(8888);
    }
}
