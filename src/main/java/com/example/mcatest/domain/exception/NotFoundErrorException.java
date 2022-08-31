package com.example.mcatest.domain.exception;

public class NotFoundErrorException extends RuntimeException{

    public NotFoundErrorException(String message) {
        super(message);
    }

    public NotFoundErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
