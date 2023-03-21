package com.example.vladimirprojectone.mapper;

import com.example.vladimirprojectone.dto.UserRequestDto;
import com.example.vladimirprojectone.dto.UserResponseDto;
import com.example.vladimirprojectone.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponseDto toDto(UserEntity entity) {
        return UserResponseDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .middleName(entity.getMiddleName())
                .lastName(entity.getLastName())
                .buildings(entity.getBuildings().stream()
                        .map(BuildingMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public UserEntity toEntity(UserRequestDto request) {
        return UserEntity.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .build();
    }

    public void updateUser(UserEntity userEntity, UserRequestDto request) {
        if (request.getFirstName() != null) {
            userEntity.setFirstName(request.getFirstName());
        }

        if (request.getMiddleName() != null) {
            userEntity.setMiddleName(request.getMiddleName());
        }

        if (request.getLastName() != null) {
            userEntity.setLastName(request.getLastName());
        }
    }
}
