package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.dto.UserCreateDto;
import com.example.vladimirprojectone.dto.UserUpdateDto;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    public String findAll() {
        return userService.findAll();
    }

    @GetMapping("/valueId/{id}")
    public String findId(@PathVariable long id) {
        return userService.findId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody UserUpdateDto request, @PathVariable long id) {
        return userService.update(request, id);
    }

    @GetMapping("/all/sorted")
    public String findAllSort() {
        return userService.findAllSort();
    }
}
