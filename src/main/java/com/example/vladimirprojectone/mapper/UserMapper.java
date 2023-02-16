package com.example.vladimirprojectone.mapper;

import com.example.vladimirprojectone.dto.UserRequestDto;
import com.example.vladimirprojectone.dto.UserResponseDto;
import com.example.vladimirprojectone.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto userEntityConvert(UserEntity request) {
        UserResponseDto userResponse = new UserResponseDto();

        userResponse.setId(request.getId());
        userResponse.setFirstName(request.getFirstName());
        userResponse.setMiddleName(request.getMiddleName());
        userResponse.setLastName(request.getLastName());

        return userResponse;
    }

    public UserEntity userRequestConvert(UserRequestDto userRequestDto) {
        UserEntity user = new UserEntity();

        user.setFirstName(userRequestDto.getFirstName());
        user.setMiddleName(userRequestDto.getMiddleName());
        user.setLastName(userRequestDto.getLastName());

        return user;
    }

    public void userUpdateRequest(UserEntity userEntity, UserRequestDto request) {
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