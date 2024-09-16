package com.mianbao.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Description: 刷题服务启动类
 * @Author:bread
 * @Date: 2024-07-25 16:57
 */


@SpringBootApplication
@ComponentScan("com.mianbao")
@MapperScan("com.mianbao.**.dao")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }
}
