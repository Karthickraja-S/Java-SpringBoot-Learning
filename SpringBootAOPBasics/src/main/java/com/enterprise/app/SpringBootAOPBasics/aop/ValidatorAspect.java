package com.enterprise.app.SpringBootAOPBasics.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidatorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorAspect.class);
    @Around("execution(* com.enterprise.app.SpringBootAOPBasics.controller.ApartmentController.divide(..)) " +
            "&& args(num)")
    public Object manipulateInput(ProceedingJoinPoint joinPoint , int num)throws Throwable {
        if(num <= 0) {
            LOGGER.info("Seems the num given is <= 0 , So passing the value as 1");
            num = 1;
        }
        return joinPoint.proceed(new Object[]{num});
    }
}
