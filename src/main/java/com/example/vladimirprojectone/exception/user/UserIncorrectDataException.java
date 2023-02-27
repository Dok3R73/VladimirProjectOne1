package com.example.vladimirprojectone.exception.user;

import com.example.vladimirprojectone.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserIncorrectDataException extends BusinessException {

    public UserIncorrectDataException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
