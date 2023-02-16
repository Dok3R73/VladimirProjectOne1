package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ExceptionControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException(BusinessException exception) {
        return String.format(" %s\n", exception.getMessage());
    }
}