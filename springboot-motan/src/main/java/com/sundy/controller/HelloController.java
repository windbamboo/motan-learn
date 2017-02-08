/*
 * Copyright 2009-2016 Weibo, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.sundy.controller;

import com.sundy.motan.service.AnnotationService;
import com.sundy.motan.service.MotanDemoService;
import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @MotanReferer(basicReferer = "motantestClientBasicConfig", group = "motan-demo-rpc", directUrl = "127.0.0.1:8002")
    AnnotationService service;

    @RequestMapping("/home")
    @ResponseBody
    public ResponseEntity home() {
        String result = service.hello("test");
        System.out.println("#############  spring boot call motan result: "+result);
        return ResponseEntity.ok(result);
    }
}
