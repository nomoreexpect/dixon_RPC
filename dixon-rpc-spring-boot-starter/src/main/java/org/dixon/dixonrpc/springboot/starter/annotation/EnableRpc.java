package org.dixon.dixonrpc.springboot.starter.annotation;

import org.dixon.dixonrpc.springboot.starter.bootstrap.RpcConsumerBootstrap;
import org.dixon.dixonrpc.springboot.starter.bootstrap.RpcInitBootstrap;
import org.dixon.dixonrpc.springboot.starter.bootstrap.RpcProviderBootstrap;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RpcInitBootstrap.class, RpcProviderBootstrap.class, RpcConsumerBootstrap.class})
public @interface EnableRpc {
    boolean needServer() default true;
}
