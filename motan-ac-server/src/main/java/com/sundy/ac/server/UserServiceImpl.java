package com.sundy.ac.server;

import com.sundy.ac.service.UserService;
import com.sundy.motan.service.MotanDemoService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liuguozhu on 2017/2/10.
 */
@MotanService(export = "8003")
public class UserServiceImpl implements UserService {

    @Autowired
    MotanDemoService motanDemoService;

    public boolean login(String name) {
        System.out.println("call userService begin");
        System.out.println("call motanDemoService begin");
        motanDemoService.hello(name);
        System.out.println("call motanDemoService end");
        System.out.println("userName is " + name);
        System.out.println("call userService end");

        return true;
    }
}
