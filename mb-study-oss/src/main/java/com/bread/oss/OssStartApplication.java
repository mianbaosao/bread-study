package com.bread.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Description: oss服务启动
 * @Author:bread
 * @Date: 2024-09-10 20:57
 */


@SpringBootApplication
@ComponentScan("com.qihang")
public class OssStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssStartApplication.class);
    }
}
