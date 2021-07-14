package com.example.publisherinqueue.controller;

import com.example.publisherinqueue.controller.dto.UserDto;
import com.example.publisherinqueue.model.User;
import com.example.publisherinqueue.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/rabbitmq")
public class ProducerController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/producer")
    public ResponseEntity<UserDto> producer(@RequestBody @Valid User user) {
        this.rabbitMQSender.send(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDto(user));
    }

}
