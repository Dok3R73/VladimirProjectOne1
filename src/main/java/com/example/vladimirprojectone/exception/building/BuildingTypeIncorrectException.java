package com.example.vladimirprojectone.exception.building;

import com.example.vladimirprojectone.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class BuildingTypeIncorrectException extends BusinessException {
    public BuildingTypeIncorrectException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
