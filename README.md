# dixon_RPC框架



## 项目介绍

基于 Java + Etcd + Vert.x 的高性能 RPC 框架，可以学习并实践基于 Vert.x 的网络服务器、序列化器、基于 Etcd 的注册中心、反射、动态代理、自定义网络协议、多种设计模式（单例 / 工厂 / 装饰者等）、负载均衡器设计、重试和容错机制、Spring Boot Starter 注解驱动开发等，大幅提升架构设计能力。


通过这个简易项目的学习，可以让你从零开始实现一个类似 Dubbo 服务框架 mini 版RPC，学到 RPC 的底层原理以及各种 Java 编码实践的运用。下面看一下RPC的调用流程：



功能&设计🚀

功能：
简单易学的代码和框架，在代码中含有大量注解
基于Vert.x实现长连接通信，包括心跳检测、解决粘包半包等
基于Etcd实现分布式服务注册与发现
实现了轮询、随机、加权随机等负载均衡算法
实现了同步调用、异步调用多种调用方式
支持jdk的动态代理方式
支持fastJson、hessian、kryo、jdk的序列化方式
支持简易扩展点，泛化调用等功能
设计：
dixon_rpc框架调用流程：



代理层：负责对底层调用细节的封装；
链路层：负责执行一些自定义的过滤链路，可以供后期二次扩展；
路由层：负责在集群目标服务中的调用筛选策略；
协议层：负责请求数据的转码封装等作用；
注册中心：关注服务的上下线，以及一些权重，配置动态调整等功能；
容错层：当服务调用出现失败之后需要有容错层的兜底辅助；




## 技术选型

### 后端

后端技术以 Java 为主，但所有的思想和设计都是可以复用到其他语言的，代码不同罢了。

- ⭐️ Vert.x 框架
- ⭐️ Etcd 云原生存储中间件（jetcd 客户端）
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
- JUnit 单元测试
- Logback 日志库
- Hutool、Lombok 工具库

## 源码目录

- dixon-rpc-V2：dixon RPC 框架核心代码
- dixon-rpc-easy：dixon RPC 框架简易版
- example-common：示例代码公用模块
- example-consumer：示例服务消费者
- example-provider：示例服务提供者
- example-springboot-consumer：示例服务消费者（Spring Boot 框架）
- example-springboot-provider：示例服务提供者（Spring Boot 框架）
- dixon-rpc-spring-boot-starter：注解驱动的 RPC 框架，可在 Spring Boot 项目中快速使用



# 第一版：RPC 框架简易版

1. RPC 基本概念和作用
2. 涵盖了基本设计 扩展设计 项目初始化 web 服务器 本地服务注册器 序列化器 请求处理器 消费者代理 测试验证


# 第二版：RPC 框架扩展版
## 功能&设计🚀
___
# 功能
* 简单易学的代码和框架，在代码中含有大量注解
* 基于`Vert.x`实现长连接通信，包括心跳检测、解决粘包半包等
* 基于`Etcd`实现分布式服务注册与发现
* 实现了轮询、随机、加权随机等负载均衡算法
* 实现了同步调用、异步调用多种调用方式
* 支持`jdk`的动态代理方式 
* 支持`fastJson`、`hessian`、`kryo`、`jdk`的序列化方式
* 支持简易扩展，泛化调用等功能

<<<<<<< HEAD
## 设计
`dixon_rpc`框架调用流程：

![img.png](img.png)

1. 服务提供者启动服务
2. 服务消费者调用服务
3. 服务提供者处理请求
4. 服务提供者响应请求
5. 服务消费端重试和容错
=======
1. 全局配置加载 | 扩展版项目初始化
2. 全局配置加载 | 配置加载实现
3. 全局配置加载 | 维护全局配置对象
4. 接口 Mock 设计实现
5. 序列化器 | 主流序列化器对比
6. 序列化器 | 多种序列化器实现
7. 序列化器 | SPI 机制
8. 序列化器 | 可扩展序列化器实现（SPI + 工厂模式）
9. 注册中心 | 注册中心核心能力
10. 注册中心 | 注册中心技术选型
11. 注册中心 | Etcd 云原生中间件入门
12. 注册中心 | 基于 Etcd 实现注册中心
13. 注册中心 | 可扩展注册中心实现（SPI + 工厂模式）
14. 注册中心优化 | 心跳检测和续期机制
15. 注册中心优化 | 服务节点下线机制
16. 注册中心优化 | 消费端服务缓存
17. 注册中心优化 | 缓存更新（Etcd 监听机制）
18. 自定义协议 | 需求分析及方案设计
19. 自定义协议 | 消息结构设计（参考 Dubbo）
20. 自定义协议 | 网络传输设计（基于 Vert.x 实现 TCP 服务器）
21. 自定义协议 | 编码 / 解码器
22. 自定义协议 | TCP 请求处理器
23. 自定义协议 | TCP 请求客户端
24. 自定义协议 | 粘包半包问题分析
25. 自定义协议 | 使用 Vert.x 解决粘包半包问题
26. 自定义协议 | 客户端代码优化（装饰者模式）
27. 负载均衡 | 负载均衡概念和常用算法
28. 负载均衡 | 一致性 Hash
29. 负载均衡 | 多种负载均衡器实现
30. 负载均衡 | 可扩展负载均衡器实现（SPI + 工厂模式）
31. 重试机制 | 重试等待策略
32. 重试机制 | 重试方案设计
33. 重试机制 | 多种重试策略实现
34. 重试机制 | 可扩展重试策略实现（SPI + 工厂模式）
35. 容错机制 | 容错策略和实现方式
36. 容错机制 | 容错方案设计
37. 容错机制 | 多种容错策略实现
38. 容错机制 | 可扩展容错策略实现（SPI + 工厂模式）
39. 启动机制 | 框架快速启动类
40. 启动机制 | 注解驱动设计
41. 启动机制 | Spring Boot Starter 注解驱动实现
>>>>>>> 20db8392fcb1f484350afd8c147db5c3ef04404b
