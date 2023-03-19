package com.example.vladimirprojectone.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "idUser", sequenceName = "idUserSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idUser")
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BuildingEntity> buildings;

    public UserEntity() {

    }

    public List<BuildingEntity> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
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
        return firstName + " " + middleName + " " + lastName;
    }
}
