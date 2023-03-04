package com.example.vladimirprojectone.mapper;

import com.example.vladimirprojectone.dto.BuildingRequestDto;
import com.example.vladimirprojectone.dto.BuildingResponseDto;
import com.example.vladimirprojectone.dto.UserRequestDto;
import com.example.vladimirprojectone.dto.UserResponseDto;
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

    public static BuildingResponseDto toDto(BuildingEntity request) {
        BuildingResponseDto buildingResponseDto = new BuildingResponseDto();

        buildingResponseDto.setId(request.getId());
        buildingResponseDto.setBuildingType(request.getBuildingType());
        buildingResponseDto.setAddress(request.getAddress());
        buildingResponseDto.setArea(request.getArea());

        return buildingResponseDto;
    }
}
