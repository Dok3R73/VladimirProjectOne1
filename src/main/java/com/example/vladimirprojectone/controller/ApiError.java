package com.example.vladimirprojectone.controller;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
