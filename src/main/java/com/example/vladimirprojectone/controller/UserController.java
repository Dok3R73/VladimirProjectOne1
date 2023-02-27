package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.dto.UserRequestDto;
import com.example.vladimirprojectone.dto.UserResponseDto;
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
    public String create(@RequestBody UserRequestDto request) {
        return userService.create(request);
    }

    @GetMapping("/all")
    public List<UserResponseDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto findId(@PathVariable Long id) {
        return userService.findId(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody UserRequestDto request, @PathVariable Long id) {
        return userService.update(request, id);
    }

    @GetMapping("/all/sorted")
    public List<UserResponseDto> findAllSort() {
        return userService.findAllSort();
    }
}
