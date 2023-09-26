package com.liuqiang.ssyx.mq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 添加消息的确认配置
 * @date 2023/9/26 11:27
 */
@Component
public class MQProducerAckConfig implements RabbitTemplate.ReturnCallback,RabbitTemplate.ConfirmCallback {
    //  我们发送消息使用的是 private RabbitTemplate rabbitTemplate; 对象
    //  如果不做设置的话 当前的rabbitTemplate 与当前的配置类没有任何关系！
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //  设置 表示修饰一个非静态的void方法，在服务器加载Servlet的时候运行。并且只执行一次！
    @PostConstruct
    public void init(){
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     *  表示消息是否正确发送到了交换机上
     * @param correlationData 消息的载体
     * @param b 判断是否发送到交换机上
     * @param s  原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b){
            System.out.println("消息发送成功！");
        }else {
            System.out.println("消息发送失败！"+s);
        }

    }

    /**
     * 消息如果没有正确发送到队列中，则会走这个方法！如果消息被正常处理，则这个方法不会走！
     * @param message 消息
     * @param replyCode 应答码
     * @param replyText 描述
     * @param exchange 消息使用的交换器
     * @param routingKey  消息使用的路由键
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey){
        System.out.println("消息主体: " + new String(message.getBody()));
        System.out.println("应答码: " + replyCode);
        System.out.println("描述：" + replyText);
        System.out.println("消息使用的交换器 exchange : " + exchange);
        System.out.println("消息使用的路由键 routing : " + routingKey);

    }
}
