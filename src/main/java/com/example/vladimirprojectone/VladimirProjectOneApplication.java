package com.example.vladimirprojectone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class VladimirProjectOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(VladimirProjectOneApplication.class, args);
    }

    @GetMapping("/hello")
    public List<String> hello() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("Hello");
        }
        return list;
    }
@GetMapping("/test")
    public String test(){
        return "Test method";
    }

}
