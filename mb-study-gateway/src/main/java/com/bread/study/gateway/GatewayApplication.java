package com.bread.study.gateway;

import cn.dev33.satoken.SaManager;
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
        System.out.println("\n启动成功：Sa-Token配置如下：" + SaManager.getConfig());
        SpringApplication.run(GatewayApplication.class);
    }

}
