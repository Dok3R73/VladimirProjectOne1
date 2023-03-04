package com.example.vladimirprojectone.repository;

import com.example.vladimirprojectone.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
}
