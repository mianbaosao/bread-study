package com.mianbao.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: 启动类
 * @Author:bread
 * @Date: 2024-09-20 16:48
 */
@SpringBootApplication
@ComponentScan("com.mianbao")
public class WxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class);
    }
}
