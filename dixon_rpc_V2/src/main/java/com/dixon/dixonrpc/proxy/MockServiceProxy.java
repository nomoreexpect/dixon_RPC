package com.dixon.dixonrpc.proxy;
import com.dixon.example.commpn.model.User;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:PanYa
 * @Date 2024/6/20-上午10:25
 * @Description:
 */
@Slf4j
public class MockServiceProxy  implements InvocationHandler {
    private static final Faker faker = new Faker();
    /*
    *@Param
    *@return
    *@Description: 调用代理
    */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 根据方法的返回值类型，生成特定的默认值对象
        Class<?> methodReturnType = method.getReturnType();
        log.info("mock invoke {}", method.getName());
        return getDefaultObject(methodReturnType);
    }


    private Object getDefaultObject(Class<?> type) {
        // 基本类型
//        if (type.isPrimitive()) {
//            if (type == boolean.class) {
//                return false;
//            } else if (type == short.class) {
//                return (short) 0;
//            } else if (type == int.class) {
//                return 0;
//            } else if (type == long.class) {
//                return 0L;
//            }
//        }
        if (type.isAssignableFrom(String.class)) {
            return faker.lorem().sentence();
        } else if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
            return faker.number().randomDigit();
        } else if (type.isAssignableFrom(double.class) || type.isAssignableFrom(Double.class)) {
            return faker.number().randomDouble(2, 1, 100);
        } else if (type.isAssignableFrom(User.class)) {
            User user = new User(); // 创建 User 对象
            user.setName(faker.name().fullName()); // 设置 name
            return user;
        }

        // 对象类型
        return null;
    }

}
