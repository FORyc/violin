package com.blogs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.blogs.xuan.mapper"})
public class MyBlogsApplication {
    public static void main(String[] arg){
        SpringApplication.run(MyBlogsApplication.class, arg);
    }
}
