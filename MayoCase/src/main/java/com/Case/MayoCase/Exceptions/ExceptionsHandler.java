package com.Case.MayoCase.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExeptionResponse> handleSercurity(BusinessException e){

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExeptionResponse(e.getMessage()));

    }

}