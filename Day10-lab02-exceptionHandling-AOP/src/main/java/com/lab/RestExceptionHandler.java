package com.lab;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String fieldName = fieldError.getField();
            String errorMsg = fieldError.getDefaultMessage();
            errors.put(fieldName, errorMsg);
        }
//        errors.put("a", "aop");
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    private ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
//        Map<String, String> errors = new HashMap<>();
//        errors.put("Error", "Entity Not Found");
//        //add more details
//        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
//    }
}