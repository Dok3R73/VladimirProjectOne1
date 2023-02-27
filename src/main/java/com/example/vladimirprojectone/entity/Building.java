package com.example.vladimirprojectone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Building {

    @Id
    @SequenceGenerator(name = "idBuilding", sequenceName = "idBuildingSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idBuilding")
    private Long id;

    @ManyToOne
    private UserEntity user;
}
