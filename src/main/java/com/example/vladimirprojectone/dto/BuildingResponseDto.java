package com.example.vladimirprojectone.dto;

import com.example.vladimirprojectone.entity.enums.BuildingType;

import java.math.BigDecimal;

public class BuildingResponseDto {

    private Long id;

    private String address;
    private BigDecimal area;
    private BuildingType buildingType;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    @Override
    public String toString() {
        return "BuildingResponseDto{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", buildingType=" + buildingType +
                '}';
    }
}
