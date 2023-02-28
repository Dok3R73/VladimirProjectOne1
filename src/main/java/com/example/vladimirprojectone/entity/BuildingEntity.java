package com.example.vladimirprojectone.entity;

import com.example.vladimirprojectone.source.Property;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "buildings")
public class BuildingEntity {

    @Id
    @SequenceGenerator(name = "idBuilding", sequenceName = "idBuildingSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idBuilding")
    private Long id;

    private String adress;
    private BigDecimal area;
    private Property property;

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
