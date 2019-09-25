package com.feri.onedrive.api.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 10:48
 */
@Configuration
public class RabbitMQConfig {

    public static String qName="escar";
    //创建队列
    @Bean
    public Queue createQueue(){
       return new Queue(qName);
    }

}
