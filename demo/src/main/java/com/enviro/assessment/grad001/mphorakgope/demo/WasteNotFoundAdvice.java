package com.enviro.assessment.grad001.mphorakgope.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WasteNotFoundAdvice {
    @ExceptionHandler(WasteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String wasteNotFoundHandler(WasteNotFoundException ex){
        return ex.getMessage();
    }
}
