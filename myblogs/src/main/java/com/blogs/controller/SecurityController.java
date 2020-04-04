package com.blogs.controller;

import com.blogs.configuration.security.util.JwtUtils;
import com.blogs.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import top.api.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SecurityController {

    @Autowired
    private JwtUtils jwtUtils;
    @Value("${jwt.tokenPrefix}")
    private String jwtTokenPrefix;


    @GetMapping(value = "/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping(value = "/admin/login")
    public String login(){
        return Api.success();
    }

    @GetMapping(value = "/api/getToken")
    public String getToken(){
        if(true){
            AdminUser adminUser = new AdminUser();
            adminUser.setUsername("123456");
            String token = jwtTokenPrefix + jwtUtils.generateToken(adminUser);
            return Api.success(token);
        }
        return Api.success();
    }

    @GetMapping(value = "/api/refreshToken")
    public String refreshToken(){
        return Api.success();
    }
}
