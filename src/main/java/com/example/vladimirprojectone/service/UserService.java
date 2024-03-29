package com.example.vladimirprojectone.service;

import com.example.vladimirprojectone.dto.UserRequestDto;
import com.example.vladimirprojectone.dto.UserResponseDto;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.exception.user.UserNotFoundException;
import com.example.vladimirprojectone.mapper.UserMapper;
import com.example.vladimirprojectone.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public String create(UserRequestDto request) {
        log.info("Заспрос на создание пользователя {}", request);

        UserEntity userEntity = userMapper.toEntity(request);

        save(userEntity);

        return String.format("Создан пользователь %s %s %s",
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName());
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<UserResponseDto> findAllSort() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .sorted((Comparator.comparing(UserResponseDto::getId)))
                .collect(Collectors.toList());
    }

    public UserResponseDto findId(Long id) {
        UserEntity user = findById(id);

        return userMapper.toDto(user);
    }

    public String delete(Long id) {
        log.info("Заспрос на удаление пользователя {}", id);

        UserEntity user = findById(id);

        userRepository.delete(user);
        return "Пользователь удален";
    }

    public String update(UserRequestDto request, Long id) {
        log.info("Заспрос на обновление данных пользователя {}{}", request, id);

        UserEntity userEntity = findById(id);

        userMapper.updateUser(userEntity, request);

        save(userEntity);

        return "Данные пользователя успешно изменены";
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден", HttpStatus.NOT_FOUND));
    }
}
