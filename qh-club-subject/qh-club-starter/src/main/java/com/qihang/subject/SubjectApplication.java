package com.qihang.subject;

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
@ComponentScan("com.qihang")
@MapperScan("com.qihang.**.dao")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
