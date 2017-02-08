package com.sundy.motan.client;

import com.sundy.motan.service.MotanDemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuguozhu on 2017/2/7.
 */
public class DemoClient {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:motan_client.xml");
        MotanDemoService service = (MotanDemoService) ctx.getBean("motanDemoService");
        for (int i=0;i<100000;i++){
            System.out.println(service.hello("motan"+i));
            Thread.sleep(1000l);
        }

    }
}
