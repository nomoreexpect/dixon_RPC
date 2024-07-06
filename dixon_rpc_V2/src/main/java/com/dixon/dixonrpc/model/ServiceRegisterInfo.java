package com.dixon.dixonrpc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:PanYa
 * @Date 2024/7/6-下午4:45
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRegisterInfo<T> {

    //服务名称
    private String serviceName;

    //实现类
    private Class<? extends T> implClass;
}
