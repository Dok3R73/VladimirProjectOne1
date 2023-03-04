package com.example.vladimirprojectone.entity;

import com.example.vladimirprojectone.entity.enums.BuildingType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "building")
public class BuildingEntity {

    @Id
    @SequenceGenerator(name = "idBuilding", sequenceName = "idBuildingSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idBuilding")
    private Long id;

    private String address;
    private BigDecimal area;
    private BuildingType buildingType;

    @ManyToOne
    private UserEntity user;

    public BuildingEntity() {

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
