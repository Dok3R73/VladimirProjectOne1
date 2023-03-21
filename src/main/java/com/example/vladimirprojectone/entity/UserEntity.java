package com.example.vladimirprojectone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @SequenceGenerator(name = "idUser", sequenceName = "idUserSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idUser")
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<BuildingEntity> buildings;

    public UserEntity() {

    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName;
    }
}
