package com.example.vladimirprojectone.exception.building;

import com.example.vladimirprojectone.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class BuildingNotFoundException extends BusinessException {
    public BuildingNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
