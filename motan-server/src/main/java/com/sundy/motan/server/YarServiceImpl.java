package com.sundy.motan.server;

import com.sundy.motan.service.YarService;

/**
 * Created by liuguozhu on 2017/2/7.
 */
public class YarServiceImpl implements YarService {

    public String hello(String name) {
        System.out.println(name + " invoked rpc service");
        return "hello " + name;
    }
}
