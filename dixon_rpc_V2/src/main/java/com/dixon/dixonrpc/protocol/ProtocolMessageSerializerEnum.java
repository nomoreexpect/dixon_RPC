package com.dixon.dixonrpc.protocol;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum ProtocolMessageSerializerEnum {
    JDK(0, "jdk"),
    JSON(1, "json"),
    KRYO(2, "kryo"),
    HESSIAN(3, "hessian");

    private final int key;

    private final String value;

    ProtocolMessageSerializerEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static List<String> getValues() {
        /*
        *@Param []
        *@return java.util.List<java.lang.String>
        *@Description:  获取值列表      
        */
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    public static ProtocolMessageSerializerEnum getEnumByKey(int key) {
        /*
        *@Param [key]
        *@return com.dixon.dixonrpc.protocol.ProtocolMessageSerializerEnum
        *@Description:根据 key 获取枚举
        */
        for (ProtocolMessageSerializerEnum anEnum : ProtocolMessageSerializerEnum.values()) {
            if (anEnum.key == key) {
                return anEnum;
            }
        }
        return null;
    }

    public static ProtocolMessageSerializerEnum getEnumByValue(String value) {
        /*
        *@Param [value]
        *@return com.dixon.dixonrpc.protocol.ProtocolMessageSerializerEnum
        *@Description: 根据 value 获取枚举
        */
        if (ObjectUtil.isEmpty(value)) {
            return null;
        }
        for (ProtocolMessageSerializerEnum anEnum : ProtocolMessageSerializerEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }
}
