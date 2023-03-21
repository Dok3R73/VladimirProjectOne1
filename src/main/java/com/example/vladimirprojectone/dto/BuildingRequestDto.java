package com.example.vladimirprojectone.dto;

import com.example.vladimirprojectone.entity.enums.BuildingType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BuildingRequestDto {

    private Long userId;
    private String address;
    private BigDecimal area;
    private BuildingType buildingType;
}
