package com.mianbao.forum.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: 社区启动类
 * @Author:bread
 * @Date: 2024-10-17 18:45
 */
@SpringBootApplication
@MapperScan("com.mianbao.**.dao")
@ComponentScan(basePackages = "com.mianbao")
public class ForumApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class);
    }
}
