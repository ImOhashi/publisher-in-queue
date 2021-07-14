package com.example.publisherinqueue.controller.dto;

import com.example.publisherinqueue.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private String name;
    private String surname;

    public UserDto(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static List<UserDto> convert(List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }
}
