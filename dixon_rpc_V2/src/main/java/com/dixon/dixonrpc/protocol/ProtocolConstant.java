package com.dixon.dixonrpc.protocol;

/**
 * @Author:PanYa
 * @Date 2024/7/3-上午10:03
 * @Description:
 */
public interface ProtocolConstant {

    //消息体长度
    int MESSAGE_HEADER_LENGTH = 17;

    //协议魔数
    byte PROTOCOL_MAGIC = 0x1;

    //协议版本号
    byte PROTOCOL_VERSION = 0x1;
}
