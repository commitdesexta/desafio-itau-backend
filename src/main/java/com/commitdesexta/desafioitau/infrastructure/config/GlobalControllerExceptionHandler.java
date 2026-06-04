package com.commitdesexta.desafioitau.infrastructure.config;

import com.commitdesexta.desafioitau.domain.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Void> handleDomainException(DomainException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Void> handleDomainException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleDomainException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
}
