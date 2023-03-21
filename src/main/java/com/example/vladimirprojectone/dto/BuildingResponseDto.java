package com.example.vladimirprojectone.dto;

import com.example.vladimirprojectone.entity.enums.BuildingType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BuildingResponseDto {

    private Long id;
    private String address;
    private BigDecimal area;
    private BuildingType buildingType;
    private String userName;
}
