package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.dto.UserCreateDto;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String create(@RequestBody UserCreateDto request) {
        return userService.create(request);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }
}
