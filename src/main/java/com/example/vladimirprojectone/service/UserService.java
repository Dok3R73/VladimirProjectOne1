package com.example.vladimirprojectone.service;

import com.example.vladimirprojectone.dto.UserCreateDto;
import com.example.vladimirprojectone.dto.UserUpdateDto;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String create(UserCreateDto request) {
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(request.getFirstName());
        userEntity.setMiddleName(request.getMiddleName());
        userEntity.setLastName(request.getLastName());

        UserEntity savedUser = userRepository.save(userEntity);

        return String.format("Создан пользователь %s %s %s",
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName());
    }

    public String findAll() {
        List<UserEntity> list = userRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (var user : list
        ) {
            stringBuilder.append(user.getId()).append(" - ").append(user.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String findAllSort() {
        List<UserEntity> list = userRepository.findAll();
        list.sort(Comparator.comparing(UserEntity::getId));
        StringBuilder stringBuilder = new StringBuilder();
        for (var user : list
        ) {
            stringBuilder.append(user.getId()).append(" - ").append(user.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String findId(long id) {
        var user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return "Пользователь не найден";
        }

        return user.toString();
    }

    public String delete(long id) {
        var user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return "Пользователь не найден";
        } else {
            userRepository.delete(user);
            return "Пользователь удален";
        }
    }

    public String update(UserUpdateDto request, long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);

        if (userEntity == null) {
            return "Пользователь не найден";
        } else {
            userEntity.setFirstName(request.getFirstName());
            userEntity.setMiddleName(request.getMiddleName());
            userEntity.setLastName(request.getLastName());

            userRepository.save(userEntity);

            return "Данные пользователя успешно изменены";
        }
    }
}
