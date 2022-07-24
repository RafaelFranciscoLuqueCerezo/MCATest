package com.example.mcatest.domain.exception;

public class NotFoundRestTemplateErrorException extends RuntimeException{

    public NotFoundRestTemplateErrorException(String message) {
        super(message);
    }

    public NotFoundRestTemplateErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
