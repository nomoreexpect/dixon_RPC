# dixon_RPC框架



## 项目介绍

基于 Java + Etcd + Vert.x 的高性能 RPC 框架，可以学习并实践基于 Vert.x 的网络服务器、序列化器、基于 Etcd 的注册中心、反射、动态代理、自定义网络协议、多种设计模式（单例 / 工厂 / 装饰者等）、负载均衡器设计、重试和容错机制、Spring Boot Starter 注解驱动开发等，大幅提升架构设计能力。







## 技术选型

### 后端

后端技术以 Java 为主，但所有的思想和设计都是可以复用到其他语言的，代码不同罢了。
（很多都是饼，尚未实现）
- ⭐️ Vert.x 框架
- ⭐️ Etcd 云原生存储中间件（jetcd 客户端）
- ZooKeeper 分布式协调工具（curator 客户端）
- ⭐️ SPI 机制
- ⭐️ 多种序列化器
    - JSON 序列化
    - Kryo 序列化
    - Hessian 序列化
- ⭐️ 多种设计模式
    - 双检锁单例模式
    - 工厂模式
    - 代理模式
    - 装饰者模式
- ⭐️ Spring Boot Starter 开发
- 反射和注解驱动
- Guava Retrying 重试库
- JUnit 单元测试
- Logback 日志库
- Hutool、Lombok 工具库

## 源码目录

- dixon-rpc-easy：dixon RPC 框架简易版
- example-common：示例代码公用模块
- example-consumer：示例服务消费者
- example-provider：示例服务提供者


### 第一版：RPC 框架简易版

1. RPC 基本概念和作用
2. RPC 框架实现思路 | 基本设计
3. RPC 框架实现思路 | 扩展设计
4. 简易版 RPC 开发 | 项目初始化
5. 简易版 RPC 开发 | web 服务器
6. 简易版 RPC 开发 | 本地服务注册器
7. 简易版 RPC 开发 | 序列化器
8. 简易版 RPC 开发 | 请求处理器
9. 简易版 RPC 开发 | 消费者代理
10. 简易版 RPC 开发 | 测试验证
