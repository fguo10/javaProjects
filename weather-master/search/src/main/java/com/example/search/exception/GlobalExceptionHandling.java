package com.example.search.exception;

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


    @ExceptionHandler(SearchException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(SearchException exception, WebRequest webRequest) {

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false), "SearchException");

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

}
