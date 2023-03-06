package com.example.vladimirprojectone.service;

import com.example.vladimirprojectone.dto.BuildingRequestDto;
import com.example.vladimirprojectone.dto.BuildingResponseDto;
import com.example.vladimirprojectone.entity.BuildingEntity;
import com.example.vladimirprojectone.entity.UserEntity;
import com.example.vladimirprojectone.exception.building.BuildingNotFoundException;
import com.example.vladimirprojectone.mapper.BuildingMapper;
import com.example.vladimirprojectone.repository.BuildingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public String create(BuildingRequestDto requestDto) {
        UserEntity userEntity = userService.findById(requestDto.getUserId());

        BuildingEntity buildingEntity = buildingMapper.toEntity(requestDto, userEntity);

        userEntity.getBuildings().add(buildingEntity);

        save(buildingEntity);

        return "Создано успешно";
    }

    public void save(BuildingEntity buildingEntity) {
        buildingRepository.save(buildingEntity);
    }

    public List<BuildingResponseDto> findAll() {
        return buildingRepository.findAll().stream()
                .map(BuildingMapper::toDtoTableScore)
                .collect(Collectors.toList());
    }

    public String delete(Long id) {
        BuildingEntity build = findById(id);

        build.getUser().getBuildings().remove(build);

        userService.save(build.getUser());

        buildingRepository.delete(build);

        return "Недвижимость удалена";
    }

    public BuildingEntity findById(Long id) {
        return buildingRepository.findById(id)
                .orElseThrow(() -> new BuildingNotFoundException("Недвижимость не найдена", HttpStatus.NOT_FOUND));
    }

    public BuildingResponseDto findId(Long id) {
        BuildingEntity building = findById(id);

        return BuildingMapper.toDtoTableScore(building);
    }
}
