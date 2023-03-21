package com.example.vladimirprojectone.entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @BatchSize(size = 50)
    private List<BuildingEntity> buildings;

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName;
    }
}
