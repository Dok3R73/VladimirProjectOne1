package com.example.vladimirprojectone.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;

    public static ApiError buildApiError(String message, HttpStatus httpStatus) {
        ApiError apiError = new ApiError();

        apiError.setMessage(message);
        apiError.setHttpStatus(httpStatus);
        apiError.setTimestamp(LocalDateTime.now());

        return apiError;
    }
}
