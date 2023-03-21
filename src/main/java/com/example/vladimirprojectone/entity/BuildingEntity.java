package com.example.vladimirprojectone.entity;

import com.example.vladimirprojectone.entity.enums.BuildingType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "building")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
