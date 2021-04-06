package com.example.demo.exception;

import com.example.demo.shared.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(UserNotFoundException e)
    {
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.setErrorReportingTime(System.currentTimeMillis());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleEmailException(EmailNotFoundException e)
    {
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage("email not found exception");
        response.setErrorReportingTime(System.currentTimeMillis());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAnyException(Exception e)
    {
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.setErrorReportingTime(System.currentTimeMillis());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
