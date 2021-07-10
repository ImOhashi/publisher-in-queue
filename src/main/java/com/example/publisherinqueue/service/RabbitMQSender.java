package com.example.publisherinqueue.service;

import com.example.publisherinqueue.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("rabbitmq.routingkey")
    private String routingKey;

    public void send(User user) {
        this.rabbitTemplate.convertAndSend(this.exchange, this.routingKey, user);
        System.out.println("Published in queue!");
    }

}
