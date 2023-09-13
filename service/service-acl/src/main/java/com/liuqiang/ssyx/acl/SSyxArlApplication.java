package com.liuqiang.ssyx.acl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: Arl启动类
 * @date 2023/8/21 18:41
 */
@SpringBootApplication
@ComponentScan("com.liuqiang.ssyx")
@EnableDiscoveryClient
public class SSyxArlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSyxArlApplication.class,args);
    }
}
