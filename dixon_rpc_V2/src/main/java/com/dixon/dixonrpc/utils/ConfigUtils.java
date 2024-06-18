package com.dixon.dixonrpc.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * @Author:PanYa
 * @Date 2024/6/18-下午2:19
 * @Description: 配置工具类
 */
public class ConfigUtils {

    public static <T> T loadConfig(Class<T> tClass, String prefix) {
        /*
        *@Param [tClass, prefix]
        *@return T
        *@Description: 加载配置对象
        */
        return loadConfig(tClass, prefix, "");
    }

    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
        /*
        *@Param [tClass, prefix, environment]
        *@return T
        *@Description: 加载配置对象，支持区分环境
        */
        StringBuilder configFileBuilder = new StringBuilder("application");
        if (StrUtil.isNotBlank(environment)) {
            configFileBuilder.append("-").append(environment);
        }
        configFileBuilder.append(".properties");
        Props props = new Props(configFileBuilder.toString());
        return props.toBean(tClass, prefix);
    }
}
