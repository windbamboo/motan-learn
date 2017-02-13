package com.sundy.controller2;

import com.sundy.ac.service.UserService;
import com.sundy.motan.service.AnnotationService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


import com.sundy.motan.service.AnnotationService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import okhttp3.OkHttpClient;

import java.io.IOException;

/**
 * Created by liuguozhu on 2017/2/10.
 */


@RestController
public class LoginController {

    @MotanReferer()
    UserService service;


    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity home() throws IOException, InterruptedException {
        boolean result = service.login("test");
        System.out.println("#############  spring boot call motan result: " + result);
        return ResponseEntity.ok(result);
    }
}
