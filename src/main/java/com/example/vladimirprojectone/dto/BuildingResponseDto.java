package com.example.vladimirprojectone.dto;

import com.example.vladimirprojectone.entity.enums.BuildingType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BuildingResponseDto {

    private Long id;
    private String address;
    private BigDecimal area;
    private BuildingType buildingType;
    private String userName;
}
