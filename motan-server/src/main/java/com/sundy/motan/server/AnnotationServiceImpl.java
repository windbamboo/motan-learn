package com.sundy.motan.server;

import com.sundy.motan.service.AnnotationService;
import com.weibo.api.motan.config.springsupport.annotation.MotanService;

import java.util.Random;

/**
 * Created by liuguozhu on 2017/2/7.
 */
@MotanService(export = "8002")
public class AnnotationServiceImpl implements AnnotationService {

    public String hello(String name) {
        System.out.println(name);
        return "Hello " + name + "!";
    }
}
