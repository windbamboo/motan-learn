package com.sundy.motan.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuguozhu on 2017/2/7.
 */
public class DemoServer {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:motan_demo_server.xml");
        System.out.println("server start...");
    }
}
