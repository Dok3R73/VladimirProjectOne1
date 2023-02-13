package com.example.vladimirprojectone.service;

import com.example.vladimirprojectone.dto.UserCreateDto;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
