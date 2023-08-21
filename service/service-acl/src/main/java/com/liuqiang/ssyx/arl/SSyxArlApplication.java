package com.liuqiang.ssyx.arl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: Arl启动类
 * @date 2023/8/21 18:41
 */
@SpringBootApplication
@ComponentScan("com.liuqiang.ssyx")
public class SSyxArlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSyxArlApplication.class,args);

    }
}
