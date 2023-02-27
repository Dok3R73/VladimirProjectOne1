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
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
        UserEntity userEntity = userMapper.userRequestConvert(request);

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
                .map(userMapper::userEntityConvert)
                .collect(Collectors.toList());
    }

    public List<UserResponseDto> findAllSort() {
        return userRepository.findAll().stream()
                .map(userMapper::userEntityConvert)
                .sorted(((o1, o2) -> o1.getId().compareTo(o2.getId())))
                .collect(Collectors.toList());
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
        throw new UserIncorrectDataException("Вы ввели не верные данные", HttpStatus.CONFLICT);
//        return userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("Пользователь Не найден", HttpStatus.NOT_FOUND));
    }
}
