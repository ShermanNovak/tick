package com.tick.ticketsservice.controller;

import com.tick.ticketsservice.exception.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionCatcher {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> no_event(Exception e) {
        return ResponseEntity.status(400).body(new ErrorMessage(e.getMessage(), 400));
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<?> no_body() {
        return ResponseEntity.status(400).body(new ErrorMessage("Missing or malformed request body", 400));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> wrong_type() {
        return ResponseEntity.status(400).body(new ErrorMessage("Formatting exception", 400));
    }

    @ExceptionHandler(WebException.class)
    public ResponseEntity<?> generic_exception(WebException e) {
        int status = e.getStatus();
        return ResponseEntity.status(status)
            .body(new ErrorMessage(e.getMessage(), status));
    }
}
