package com.blogs.controller;

import api.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SecurityController {

    @GetMapping(value = "/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping(value = "/admin/login")
    public String login(HttpSession httpSession){
        httpSession.setAttribute("username", "admin-test");
        return Api.success(httpSession);
    }
}
