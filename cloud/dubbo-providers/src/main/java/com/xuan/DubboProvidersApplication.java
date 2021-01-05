package com.xuan;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 9527
 */
//@EnableDubbo(scanBasePackages="com.xuan.service.*")
@EnableDiscoveryClient
@SpringBootApplication
public class DubboProvidersApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProvidersApplication.class, args);
    }
}
