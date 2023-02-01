package com.globant.exercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InvalidParameterException.class)
    public ResponseEntity blogNotFoundException(InvalidParameterException blogNotFoundException) {
        return new ResponseEntity<String>("Invalid parameter", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity<>("Execution failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
