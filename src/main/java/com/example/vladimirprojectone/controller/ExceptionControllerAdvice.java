package com.example.vladimirprojectone.controller;

import com.example.vladimirprojectone.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handle(BusinessException exception) {
        ApiError apiError = buildApiError(exception.getMessage(), exception.getHttpStatus(), exception);
        return ResponseEntity
                .status(apiError.getHttpStatus())
                .body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handle(Exception exception) {
        if (exception instanceof HttpMessageNotReadableException) {
            ApiError apiError = buildApiError("Не найден данный тип строения", HttpStatus.BAD_REQUEST, exception);
            return ResponseEntity
                    .status(apiError.getHttpStatus())
                    .body(apiError);
        } else {
            ApiError apiError = buildApiError("Что-то пошло не так...", HttpStatus.BAD_REQUEST, exception);
            return ResponseEntity
                    .status(apiError.getHttpStatus())
                    .body(apiError);
        }
    }

    public ApiError buildApiError(String message, HttpStatus httpStatus, Exception e){
        log.error(message + httpStatus.toString(), e);
        return ApiError.buildApiError(message, httpStatus);
    }
}