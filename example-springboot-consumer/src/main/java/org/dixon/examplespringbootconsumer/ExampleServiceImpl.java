package org.dixon.examplespringbootconsumer;

import com.dixon.example.commpn.model.User;
import com.dixon.example.commpn.server.UserService;
import org.dixon.dixonrpc.springboot.starter.annotation.RpcReference;
import org.springframework.stereotype.Service;

/**
 * @Author:PanYa
 * @Date 2024/7/6-下午7:09
 * @Description:
 */
@Service
public class ExampleServiceImpl {

    @RpcReference
    private UserService userService;

    public void test(){
        User user = new User();
        user.setName("dixon");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }
}
