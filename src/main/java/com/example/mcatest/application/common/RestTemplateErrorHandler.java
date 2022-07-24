package com.example.mcatest.application.common;

import com.example.mcatest.domain.exception.NotFoundRestTemplateErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return  response.getStatusCode()== HttpStatus.NOT_FOUND;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode()== HttpStatus.NOT_FOUND){
           throw new NotFoundRestTemplateErrorException("not found");
        }
    }
}
