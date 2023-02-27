package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handle(BusinessException exception) {
        ApiError apiError = ApiError.buildApiError(exception.getMessage(), exception.getHttpStatus());
        return ResponseEntity
                .status(apiError.getHttpStatus())
                .body(apiError);
    }
}