package com.example.variantservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException{

    private ExceptionMessage exceptionMessage;
    
    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(ExceptionMessage message) {
        this.exceptionMessage = message;
    }

    public CarNotFoundException(String message, ExceptionMessage exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }
}
