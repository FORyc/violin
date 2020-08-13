package com.xuan.controller;

import com.xuan.service.ProvidersService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.api.CommonResult;

@RestController
public class ConsumerController {

    @DubboReference(version = "1.0", group = "dubbo")
    private ProvidersService providersService;

    @GetMapping(value = "/get")
    public CommonResult get(){
        return CommonResult.success(providersService.get());
    }

    @GetMapping(value = "/getString")
    public CommonResult getString(@RequestParam String string){
        return CommonResult.success(providersService.getString(string));
    }
}
