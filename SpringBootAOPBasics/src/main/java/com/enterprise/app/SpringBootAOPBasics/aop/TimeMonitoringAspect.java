package com.enterprise.app.SpringBootAOPBasics.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitoringAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeMonitoringAspect.class);
    @Around("execution(* com.enterprise.app.SpringBootAOPBasics.controller.ApartmentController.*(..))")
    public Object trackTiming(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object data = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();

        LOGGER.info("Time taken for method : "+proceedingJoinPoint+ " is : "+ (endTime-startTime) );
        return data;
    }
}
