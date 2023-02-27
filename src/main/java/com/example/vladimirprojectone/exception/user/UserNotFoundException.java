package com.example.vladimirprojectone.exception.user;

import com.example.vladimirprojectone.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
