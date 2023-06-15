package com.example.student_demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(ArithmeticException exception) {
        log.warn("Exception occurs: " + exception.getMessage());
        return ResponseEntity.badRequest().body("An exception occured: " + exception.getMessage());
    }

}