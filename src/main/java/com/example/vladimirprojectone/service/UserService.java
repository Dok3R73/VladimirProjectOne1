package com.example.vladimirprojectone.service;

import com.example.vladimirprojectone.dto.UserRequestDto;
import com.example.vladimirprojectone.dto.UserResponseDto;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.exception.BusinessException;
import com.example.vladimirprojectone.exception.user.UserIncorrectDataException;
import com.example.vladimirprojectone.exception.user.UserNotFoundException;
import com.example.vladimirprojectone.mapper.UserMapper;
import com.example.vladimirprojectone.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private static final List<String> BAD_NAMES = new ArrayList<>();

    static {
        BAD_NAMES.add("Петя");
        BAD_NAMES.add("Вася");
    }

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public String create(UserRequestDto request) {
        UserEntity userEntity = userMapper.toEntity(request);

        if (!BAD_NAMES.contains(request.getFirstName())) {
            throw new UserIncorrectDataException("Не может быть имя Петя", HttpStatus.BAD_REQUEST);
        }

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
        UserEntity user = findById(id);

        userRepository.delete(user);
        return "Пользователь удален";
    }

    public String update(UserRequestDto request, Long id) {
        UserEntity userEntity = findById(id);

        userMapper.merge(userEntity, request);

        save(userEntity);

        return "Данные пользователя успешно изменены";
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
