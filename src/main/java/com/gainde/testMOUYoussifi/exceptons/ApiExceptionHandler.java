package com.gainde.testMOUYoussifi.exceptons;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value={EntityNotFoundException.class})
    public ResponseEntity<ApiException> handleEntityNotFoundException(EntityNotFoundException e){
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.NOT_FOUND,LocalDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value={RequestException.class})
    public ResponseEntity<ApiException> handleRequestException(RequestException e){
        ApiException apiException = new ApiException(e.getMessage(), e.getStatus(),LocalDateTime.now());
        return new ResponseEntity<>(apiException, e.getStatus());
    }
}



