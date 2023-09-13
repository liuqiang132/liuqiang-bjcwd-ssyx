package com.liuqiang.ssyx.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 系统管理启动类
 * @date 2023/9/4 15:26
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.liuqiang.ssyx")
@EnableDiscoveryClient
public class SysApplication {
    public static void main(String[] args) {

        SpringApplication.run(SysApplication.class,args);
    }
}
