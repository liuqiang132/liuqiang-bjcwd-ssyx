package com.liuqiang.ssyx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 网关启动类
 * @date 2023/9/7 16:33
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.liuqiang.ssyx")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
