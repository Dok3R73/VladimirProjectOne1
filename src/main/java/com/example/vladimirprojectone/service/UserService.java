package com.example.vladimirprojectone.service;

import com.example.vladimirprojectone.dto.UserCreateDto;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public List<UserEntity> findAllSorted() {
        List<UserEntity> list = userRepository.findAll();
        list.sort(Comparator.comparing(UserEntity::getId));
        return list;
    }

    public UserEntity findId(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String deleteUser(long id) {
        userRepository.delete(Objects.requireNonNull(userRepository.findById(id).orElse(null)));
        return "Пользователь с указанным id удален";
    }

    public String update(UserCreateDto request, long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);

        userEntity.setFirstName(request.getFirstName());
        userEntity.setMiddleName(request.getMiddleName());
        userEntity.setLastName(request.getLastName());

        userRepository.save(userEntity);

        return "Данные пользователя успешно изменены";
    }
}
