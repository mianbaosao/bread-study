package com.bread.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Description: 网关服务启动
 * @Author:bread
 * @Date: 2024-09-10 20:57
 */


@SpringBootApplication
@ComponentScan("com.bread")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}
