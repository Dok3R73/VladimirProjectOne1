package com.example.vladimirprojectone.dto;

import com.example.vladimirprojectone.entity.BuildingEntity;

import java.util.List;

public class UserResponseDto {

    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;

    private List<BuildingResponseDto> buildingDtoList;

    public List<BuildingResponseDto> getBuildingDtoList() {
        return buildingDtoList;
    }

    public void setBuildingDtoList(List<BuildingResponseDto> buildingDtoList) {
        this.buildingDtoList = buildingDtoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", buildingDtoList=" + buildingDtoList +
                '}';
    }
}
