package com.sundy.motan.service;

import com.weibo.api.motan.protocol.yar.annotation.YarConfig;

/**
 * Created by liuguozhu on 2017/2/7.
 */
@YarConfig(path = "/openapi/yarserver/test")
public interface YarService {
    public String hello(String name);
}
