package com.example.exception;

import lombok.Setter;

@Setter
public class ReceiptNotFoundException extends RuntimeException{

    private String message;

    public ReceiptNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
