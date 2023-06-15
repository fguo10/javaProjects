package com.example.student_demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandling {


    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(StudentException exception, WebRequest webRequest) {

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false), "StudentException");

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

}
