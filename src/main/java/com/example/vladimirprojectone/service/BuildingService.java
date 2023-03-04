package com.example.vladimirprojectone.service;

import com.example.vladimirprojectone.dto.BuildingRequestDto;
import com.example.vladimirprojectone.entity.BuildingEntity;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.mapper.BuildingMapper;
import com.example.vladimirprojectone.repository.BuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final UserService userService;
    private final BuildingMapper buildingMapper;

    public BuildingService(BuildingRepository buildingRepository, UserService userService, BuildingMapper buildingMapper) {
        this.buildingRepository = buildingRepository;
        this.userService = userService;
        this.buildingMapper = buildingMapper;
    }

    public String create(BuildingRequestDto requestDto){
        UserEntity userEntity = userService.findById(requestDto.getUserId());

        BuildingEntity buildingEntity = buildingMapper.toEntity(requestDto, userEntity);

        userEntity.getBuildings().add(buildingEntity);

        save(buildingEntity);
        userService.save(userEntity);

        return "Создано успешно";
    }

    public void save(BuildingEntity buildingEntity) {
        buildingRepository.save(buildingEntity);
    }
}
