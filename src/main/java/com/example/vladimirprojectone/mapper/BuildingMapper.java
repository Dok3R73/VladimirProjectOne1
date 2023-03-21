package com.example.vladimirprojectone.mapper;

import com.example.vladimirprojectone.dto.BuildingRequestDto;
import com.example.vladimirprojectone.dto.BuildingResponseDto;
import com.example.vladimirprojectone.entity.BuildingEntity;
import com.example.vladimirprojectone.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {

    public BuildingEntity toEntity(BuildingRequestDto requestDto, UserEntity userEntity) {
        return BuildingEntity.builder()
                .user(userEntity)
                .address(requestDto.getAddress())
                .area(requestDto.getArea())
                .buildingType(requestDto.getBuildingType())
                .build();
    }

    public static BuildingResponseDto toDto(BuildingEntity entity) {
        return BuildingResponseDto.builder()
                .id(entity.getId())
                .buildingType(entity.getBuildingType())
                .address(entity.getAddress())
                .area(entity.getArea())
                .userName(entity.getUser().toString())
                .build();
    }
}
