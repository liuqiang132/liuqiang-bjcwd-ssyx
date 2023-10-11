package com.liuqiang.ssyx.search.rabbitmq;

import com.liuqiang.ssyx.mq.constant.MqConst;
import com.liuqiang.ssyx.search.service.SkuEsService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 接受消息监听器
 * @date 2023/9/26 12:01
 */
@Component
public class RabbitMqListener {

    @Autowired
    private SkuEsService skuEsService;
    /**
     * 接收商品上架消息
     * @param skuId  商品id
     * @param message 消息
     * @param channel 队列
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MqConst.QUEUE_GOODS_UPPER,declare = "true"),
                    exchange = @Exchange(value = MqConst.EXCHANGE_GOODS_DIRECT),
                    key = MqConst.ROUTING_GOODS_UPPER))
    public void skuUpper(Long skuId, Message message, Channel channel) throws IOException {
        if (skuId==null){
            //调用方法商品上架
            skuEsService.upperSku(skuId);
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

    }

    /**
     * 接收商品下架消息
     * @param skuId 商品id
     * @param message 消息
     * @param channel 队列
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MqConst.QUEUE_GOODS_LOWER,declare = "true"),
            exchange = @Exchange(value = MqConst.EXCHANGE_GOODS_DIRECT),
            key = MqConst.ROUTING_GOODS_LOWER))
    public void skuLower(Long skuId, Message message,Channel channel) throws IOException {
        if (skuId==null){
            //调用方法商品下架
            skuEsService.lowerSku(skuId);
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

    }


}
