package org.dixon.dixonrpc.springboot.starter.bootstrap;

import com.dixon.dixonrpc.RpcApplication;
import com.dixon.dixonrpc.config.RpcConfig;
import com.dixon.dixonrpc.server.tcp.VertxTcpServer;
import lombok.extern.slf4j.Slf4j;
import org.dixon.dixonrpc.springboot.starter.annotation.EnableRpc;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author:PanYa
 * @Date 2024/7/6-下午6:46
 * @Description:
 */
@Slf4j
public class RpcInitBootstrap implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 获取 EnableRpc 注解的属性值
        boolean needServer = (boolean) importingClassMetadata.getAnnotationAttributes(EnableRpc.class.getName())
                .get("needServer");

        // RPC 框架初始化（配置和注册中心）
        RpcApplication.init();

        // 全局配置
        final RpcConfig rpcConfig = RpcApplication.getRpcConfig();

        // 启动服务器
        if (needServer) {
            VertxTcpServer vertxTcpServer = new VertxTcpServer();
            vertxTcpServer.doStart(rpcConfig.getServerPort());
        } else {
            log.info("不启动 server");
        }

    }
}
