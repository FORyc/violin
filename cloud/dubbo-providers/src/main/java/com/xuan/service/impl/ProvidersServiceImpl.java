package com.xuan.service.impl;

import com.xuan.service.ProvidersService;
//import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

//@DubboService(version = "1.0",group = "dubbo")
@Service(version = "1.0",group = "dubbo")
public class ProvidersServiceImpl implements ProvidersService {


    @Override
    public String get() {
        return "调用成功";
    }

    @Override
    public String getString(String string) {
        return "调用成功 string = " + string;
    }
}
