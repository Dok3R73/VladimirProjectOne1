package com.example.vladimirprojectone.dto;

import com.example.vladimirprojectone.entity.enums.BuildingType;

import java.math.BigDecimal;

public class BuildingRequestDto {

    private Long userId;
    private String address;
    private BigDecimal area;
    private BuildingType buildingType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
