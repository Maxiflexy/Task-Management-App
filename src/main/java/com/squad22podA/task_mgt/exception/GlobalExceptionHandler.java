package com.squad22podA.task_mgt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception,
                                                                    WebRequest webRequest){

        ErrorResponse errorResponse = new ErrorResponse(
                                                LocalDateTime.now(), HttpStatus.CONTINUE.value(),
                                                HttpStatus.CONFLICT.getReasonPhrase(),
                                                exception.getMessage(),
                                                webRequest.getDescription(false));


        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
