package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceController {
    @Autowired
    private TestService testService;

    @GetMapping(value = "/testGet")
    public String get(){
        return testService.get();
    }
}
