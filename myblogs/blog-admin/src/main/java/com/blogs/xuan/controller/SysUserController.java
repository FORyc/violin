package com.blogs.xuan.controller;


import com.blogs.configuration.security.util.JwtUtils;
import com.blogs.dto.LoginDto;
import com.blogs.xuan.entity.SysUser;
import com.blogs.xuan.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.api.CommonResult;
import top.exception.BusinessException;
import top.exception.EmBusinessException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenPrefix}")
    private String jwtPrefix;


    @PostMapping(value = "/register")
    public CommonResult register(@RequestBody SysUser sysUser){
        boolean save = sysUserService.saveAdmin(sysUser, null);
        return save ? CommonResult.success(sysUser) : CommonResult.error("注册失败，请联系管理员");
    }

    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody LoginDto loginDto){
        String login = sysUserService.login(loginDto.getUsername(), loginDto.getPassword());
        if(StringUtils.isEmpty(login)){
            throw new BusinessException(EmBusinessException.USER_NOT_FOUND);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("token", login);
        map.put("prefix", jwtPrefix);
        return CommonResult.success(map);
    }

    @PostMapping(value = "/logout")
    public CommonResult logout(HttpServletRequest request){
        // TODO 缓存登出的token，避免已登出的token再次访问
        return CommonResult.success("登出成功");
    }


}

