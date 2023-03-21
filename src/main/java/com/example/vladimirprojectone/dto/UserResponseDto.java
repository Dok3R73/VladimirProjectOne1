package com.example.vladimirprojectone.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {

    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private List<BuildingResponseDto> buildingDtoList;
}
