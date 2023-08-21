package com.liuqiang.ssyx.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 登录启动类
 * @date 2023/8/21 19:40
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.liuqiang.ssyx")
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class,args);
    }
}
