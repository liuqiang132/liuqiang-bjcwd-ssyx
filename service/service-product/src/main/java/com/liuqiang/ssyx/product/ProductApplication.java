package com.liuqiang.ssyx.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 商品信息启动类
 * @date 2023/9/5 13:20
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.liuqiang.ssyx")
@EnableDiscoveryClient
public class ProductApplication {
    public static void main(String[] args) {

        SpringApplication.run(ProductApplication.class,args);
    }
}
