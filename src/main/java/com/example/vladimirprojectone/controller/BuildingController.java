package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.dto.BuildingRequestDto;
import com.example.vladimirprojectone.dto.BuildingResponseDto;
import com.example.vladimirprojectone.service.BuildingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/build")

public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/create")
    public String create(@RequestBody BuildingRequestDto requestDto) {
        return buildingService.create(requestDto);
    }

    @GetMapping("/all")
    public List<BuildingResponseDto> findAll() {
        return buildingService.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return buildingService.delete(id);
    }

    @GetMapping("/{id}")
    public BuildingResponseDto findId(@PathVariable Long id) {
        return buildingService.findId(id);
    }
}
