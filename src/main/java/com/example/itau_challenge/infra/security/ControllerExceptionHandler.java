package com.example.itau_challenge.infra.security;

import com.example.itau_challenge.infra.exceptions.UnprocessableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UnprocessableException.class)
    public ResponseEntity handlingUnprocessableException(UnprocessableException exception) {
        return ResponseEntity.unprocessableEntity().build();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity handlingGeneralExceptions(Exception exception) {
        return ResponseEntity.badRequest().build();
    }
}
