package com.liuqiang.ssyx.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: es搜索引擎启动类
 * @date 2023/9/14 12:14
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启nacos服务注册
@EnableFeignClients("com.liuqiang.ssyx.client.product") //开启服务的远程调用
@ComponentScan(basePackages = "com.liuqiang.ssyx")
public class EsSearchApplication {
    public static void main(String[] args) {

        SpringApplication.run(EsSearchApplication.class,args);
    }
}
