package com.example.mcatest.annotation.restTemplate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestTemplateNotFoundAspect {
    @Around("within(com.example.mcatest.microservices..*) && @annotation(RestTemplateNullWhenNotFound)")
    public Object handleRestTemplateNotFound(ProceedingJoinPoint call) {
        Object result;
        try {
            result =  call.proceed();
        } catch (Throwable exception){
            return null;
        }
        return result;
    }
}
