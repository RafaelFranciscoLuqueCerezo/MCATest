package com.example.mcatest.application.common;

import com.example.mcatest.domain.exception.ApiException;
import com.example.mcatest.domain.exception.NotFoundErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {NotFoundErrorException.class})
    public ResponseEntity<Object> handleApiNotFoundException(NotFoundErrorException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = ApiException.builder()
                .message(e.getLocalizedMessage())
                .httpStatus(notFound)
                .timestamp(ZonedDateTime.now(ZoneId.of("Z"))).build();
        return new ResponseEntity<>(apiException, notFound);
    }
}
