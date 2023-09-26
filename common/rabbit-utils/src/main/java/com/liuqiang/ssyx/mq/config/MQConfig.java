package com.liuqiang.ssyx.mq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 配置mq消息转换器
 * @date 2023/9/26 11:21
 */
@Configuration
public class MQConfig {

    @Bean
    public MessageConverter messageConverter(){

        return new Jackson2JsonMessageConverter();
    }
}
