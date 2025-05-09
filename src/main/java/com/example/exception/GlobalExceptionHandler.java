package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ReceiptNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse receiptDataNotFoundException(ReceiptNotFoundException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
    }

}
