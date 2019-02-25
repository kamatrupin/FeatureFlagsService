package com.test.ps.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomControllerAdvice.class);


    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ResponseEntity<ErrorModel> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        LOGGER.error("Handling ResourceNotFound in controller advice", ex);
        return new ResponseEntity(new ErrorModel(HttpStatus.NOT_FOUND.value(), ex.getMessage()),
                new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.error("Handling MethodArgumentNotValidException in controller advice", ex);
        return new ResponseEntity(new ErrorModel(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
