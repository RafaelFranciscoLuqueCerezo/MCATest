package com.example.mcatest.annotation.restTemplate;

import com.example.mcatest.domain.exception.NotFoundErrorException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RestTemplateNotFoundAspect {
    @Around("within(com.example.mcatest.microservices..*) && @annotation(com.example.mcatest.annotation.restTemplate.RestTemplateNotFound)")
    public Object handleRestTemplateNotFound(ProceedingJoinPoint call) {
        RestTemplateNotFound annotation = ((MethodSignature) call.getSignature()).getMethod().getAnnotation(RestTemplateNotFound.class);
        Object[] args = call.getArgs();
        Object result;
        try {
            result =  call.proceed();
        } catch (Throwable exception){
            if(exception.getClass() == NotFoundErrorException.class && annotation.throwError()){
                throw new NotFoundErrorException(String.format("parameters (%s) not found", Arrays.toString(args)));
            }
            return null;
        }
        return result;
    }
}
