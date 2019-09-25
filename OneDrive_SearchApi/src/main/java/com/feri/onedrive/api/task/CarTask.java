package com.feri.onedrive.api.task;

import com.feri.onedrive.api.config.RabbitMQConfig;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: OneDrive
 * @description: Spring Task  间隔2小时 发消息 RabbitMQ
 * @author: Feri
 * @create: 2019-09-25 10:20
 */
@Component
public class CarTask {
    @Autowired
    private AmqpTemplate amqpTemplate;

    //间隔2小时
    //@Scheduled(cron = "0 0 0/2 * * ?")
    @Scheduled(cron = "0/5 * * * * ?")
    public void execMQ(){
        //基于RabbitMQ发送消息
        amqpTemplate.convertAndSend(RabbitMQConfig.qName,"同步ES开始："+System.currentTimeMillis()/1000);
    }
}
