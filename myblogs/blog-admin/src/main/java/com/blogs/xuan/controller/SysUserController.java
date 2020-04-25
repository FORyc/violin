package com.blogs.xuan.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.api.CommonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 后台用户表--管理员 前端控制器
 * </p>
 *
 * @author 9527
 * @since 2020-04-22
 */
@Slf4j
@RestController
@RequestMapping("/admin/sys-user")
public class SysUserController {

    @PostMapping(value = "/login")
    public CommonResult login(HttpServletRequest request){
        return CommonResult.success();
    }


}

