package com.sundy.ac.client;

import com.sundy.ac.service.UserService;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuguozhu on 2017/2/7.
 */
public class ZookeeperDemoClient {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:motan_client_zookeeper.xml");
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        UserService service = (UserService) ctx.getBean("userService");
        for (int i = 0; i < 100000; i++) {
            System.out.println(service.login("motan" + i));
            Thread.sleep(1000l);
        }

    }

}
