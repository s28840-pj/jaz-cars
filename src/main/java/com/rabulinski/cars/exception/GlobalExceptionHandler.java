package com.rabulinski.cars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        push(e);
        return new ResponseEntity<>("Fatal Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BaseException.class)
    public ResponseEntity<String> handleRuntimeException(BaseException e) {
        push(e);
        return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }

    public void push(Exception e) {
        // TODO: Do something
    }
}
