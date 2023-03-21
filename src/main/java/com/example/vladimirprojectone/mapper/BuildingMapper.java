package com.example.vladimirprojectone.mapper;

import com.example.vladimirprojectone.dto.BuildingRequestDto;
import com.example.vladimirprojectone.dto.BuildingResponseDto;
import com.example.vladimirprojectone.entity.BuildingEntity;
import com.example.vladimirprojectone.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {

    public BuildingEntity toEntity(BuildingRequestDto requestDto, UserEntity userEntity) {
        BuildingEntity buildingEntity = new BuildingEntity();

        buildingEntity.setUser(userEntity);
        buildingEntity.setAddress(requestDto.getAddress());
        buildingEntity.setArea(requestDto.getArea());
        buildingEntity.setBuildingType(requestDto.getBuildingType());

        return buildingEntity;
    }

    public static BuildingResponseDto toDto(BuildingEntity entity) {
        BuildingResponseDto buildingResponseDto = new BuildingResponseDto();

        buildingResponseDto.setId(entity.getId());
        buildingResponseDto.setBuildingType(entity.getBuildingType());
        buildingResponseDto.setAddress(entity.getAddress());
        buildingResponseDto.setArea(entity.getArea());
        buildingResponseDto.setUserName(entity.getUser().getFirstName() + " " + entity.getUser().getMiddleName() + " " + entity.getUser().getLastName());

        return buildingResponseDto;
    }
}
