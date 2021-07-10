package com.example.publisherinqueue.controller;

import com.example.publisherinqueue.model.User;
import com.example.publisherinqueue.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq")
public class ProducerController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping(value = "/producer")
    public String producer(@RequestBody User user) {
        this.rabbitMQSender.send(user);
        return "Message sent to the RabbitMq successfully";
    }

}
