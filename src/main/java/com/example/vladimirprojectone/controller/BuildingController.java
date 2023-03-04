package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.dto.BuildingRequestDto;
import com.example.vladimirprojectone.service.BuildingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/build")

public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }
    @PostMapping("/create")
    public String create(@RequestBody BuildingRequestDto requestDto){
        return buildingService.create(requestDto);
    }
}
