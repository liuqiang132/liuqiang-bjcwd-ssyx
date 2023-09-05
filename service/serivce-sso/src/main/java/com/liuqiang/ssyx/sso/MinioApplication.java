package com.liuqiang.ssyx.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: MinioApplication
 * @date 2023/9/5 18:23
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.liuqiang.ssyx")
public class MinioApplication {
    public static void main(String[] args) {

        SpringApplication.run(MinioApplication.class,args);
    }
}
