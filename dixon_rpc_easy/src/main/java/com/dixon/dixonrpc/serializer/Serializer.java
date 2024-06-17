package com.dixon.dixonrpc.serializer;

import java.io.IOException;

public interface Serializer {
    //序列化
    <T> byte[] serialize(T object) throws IOException;
    //反序列化
    <T> T deserialize(byte[] data, Class<T> clazz) throws IOException;
}
