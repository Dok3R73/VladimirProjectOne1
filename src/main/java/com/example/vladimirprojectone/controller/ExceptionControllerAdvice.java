package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
   @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handle(Exception exception) {
        if (exception instanceof HttpMessageNotReadableException) {
            ApiError apiError = ApiError.buildApiError("Не найден данный тип строения", HttpStatus.BAD_REQUEST);
            return ResponseEntity
                    .status(apiError.getHttpStatus())
                    .body(apiError);
        } else {
            ApiError apiError = ApiError.buildApiError("Что-то пошло не так...", HttpStatus.BAD_REQUEST);
            return ResponseEntity
                    .status(apiError.getHttpStatus())
                    .body(apiError);
        }
    }


}