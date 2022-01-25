package com.sbz.learnings.springjpahibernate.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NoBookFoundException.class)
    public ResponseEntity<Object> handleExceptions(Exception exception) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("excep", exception.getMessage());
        ResponseEntity<Object> responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .headers(httpHeaders)
                .build();
        System.out.println("from exhandler "+ exception);
        return responseEntity;
    }
}
