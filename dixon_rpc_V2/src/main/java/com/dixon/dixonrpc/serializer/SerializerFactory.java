package com.dixon.dixonrpc.serializer;

import com.dixon.dixonrpc.spi.SpiLoader;
import com.esotericsoftware.kryo.Kryo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:PanYa
 * @Date 2024/6/26-下午9:22
 * @Description: 序列化映射（用于实现单例）
 */
public class SerializerFactory {
//    private static final Map<String, Serializer> KEY_SERIALIZER_MAP = new HashMap<String, Serializer>(){{
//        put(SerializerKeys.JDK,new JdkSerializer());
//        put(SerializerKeys.JSON,new JsonSerializer());
//        put(SerializerKeys.KRYO,new KryoSerializer());
//        put(SerializerKeys.HESSIAN,new HessianSerializer());
//    }};
//    /**
//     * 默认序列化器
//     */
//    private static final Serializer DEFAULT_SERIALIZER = KEY_SERIALIZER_MAP.get("jdk");
//
//    public static Serializer getInstance(String key){
//        return KEY_SERIALIZER_MAP.getOrDefault(key,DEFAULT_SERIALIZER);
//    }

    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class, key);
    }

}
