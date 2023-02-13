package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.dto.UserCreateDto;
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
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping("/valueId")
    public String findId(@RequestParam long id) {
        return userService.findId(id).toString();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam long id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody UserCreateDto request, @RequestParam long id) {
        return userService.update(request, id);
    }
    @GetMapping("/all/sorted")
    public List<UserEntity> findAllSort(){
        return userService.findAllSorted();
    }
}
