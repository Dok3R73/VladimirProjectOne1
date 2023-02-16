package com.example.vladimirprojectone.service;

import com.example.vladimirprojectone.dto.UserRequestDto;
import com.example.vladimirprojectone.dto.UserResponseDto;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.exception.BusinessException;
import com.example.vladimirprojectone.mapper.UserMapper;
import com.example.vladimirprojectone.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public String create(UserRequestDto request) {
        UserEntity userEntity = userMapper.userRequestConvert(request);

        save(userEntity);

        return String.format("Создан пользователь %s %s %s",
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName());
    }

    public List<UserResponseDto> findAll() {
        List<UserEntity> users = userRepository.findAll();

        List<UserResponseDto> usersDto = new ArrayList<>();

        for (UserEntity user : users) {
            usersDto.add(userMapper.userEntityConvert(user));
        }
        return usersDto;
    }

    public List<UserResponseDto> findAllSort() {
        List<UserEntity> users = userRepository.findAll();
        users.sort(Comparator.comparing(UserEntity::getId));

        List<UserResponseDto> usersDto = new ArrayList<>();

        for (UserEntity user : users) {
            usersDto.add(userMapper.userEntityConvert(user));
        }
        return usersDto;
    }

    public UserResponseDto findId(Long id) {
        UserEntity user = findById(id);

        return userMapper.userEntityConvert(user);
    }

    public String delete(Long id) {
        UserEntity user = findById(id);

        userRepository.delete(user);
        return "Пользователь удален";
    }

    public String update(UserRequestDto request, Long id) {
        UserEntity userEntity = findById(id);

        userMapper.userUpdateRequest(userEntity, request);

        save(userEntity);

        return "Данные пользователя успешно изменены";
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }


    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BusinessException("Пользователь Не найден"));
    }
}
