package com.blogs.xuan.controller;


import com.blogs.dto.LoginDto;
import com.blogs.xuan.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import top.api.CommonResult;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 9527
 * @since 2020-05-13
 */
@Slf4j
@RestController
@RequestMapping("/web/user")
public class UserController {

    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody LoginDto loginDto){
        return CommonResult.success();
    }

    @PostMapping(value = "/register")
    public CommonResult register(){
        return CommonResult.success();
    }

    @GetMapping(value = "/view/{userId}")
    public CommonResult<User> view(@PathVariable Long userId){
        return CommonResult.success();
    }
}

