package com;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client")
public interface TestService {

    @GetMapping(value = "/get")
    String get();
}
