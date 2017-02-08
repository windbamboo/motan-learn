package com.sundy.motan.client;

import com.sundy.motan.service.AnnotationService;
import com.sundy.motan.service.MotanDemoService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.weibo.api.motan.util.LoggerUtil;
import org.springframework.stereotype.Component;

/**
 * Created by fld on 16/6/1.
 */
@Component
public class DemoRpcHandler {

    @MotanReferer
    private AnnotationService annotationService;

    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(annotationService.hello("motan handler" + i));
            LoggerUtil.info("motan handler" + i);
        }

    }
}
