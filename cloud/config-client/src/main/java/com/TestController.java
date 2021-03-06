package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${env.name}")
    private String value;

    @GetMapping(value = "/get")
    public String getValue(){
        return value;
    }
}
