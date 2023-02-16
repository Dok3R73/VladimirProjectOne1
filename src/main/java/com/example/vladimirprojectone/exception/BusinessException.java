package com.example.vladimirprojectone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;


public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
