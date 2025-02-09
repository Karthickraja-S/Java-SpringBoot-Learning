package com.enterprise.app.SpringBootAOPBasics.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    // @<ADVICE>("execution( <RETURN_AGR> <class-name>.<method-name>(<accepting-params>) )" )
    // The data which specified in "" is the PointCut ( specifying when need to execute )
    // .. means consider all the args
    // https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html
    @Before("execution(* com.enterprise.app.SpringBootAOPBasics.controller.ApartmentController.*(..))" )
    public void logBefore(JoinPoint joinPoint) {
        // we can use this for tracking purpose like how many users hitting this API , so that we can handle
        // with any load balancer / optimise performance
        LOGGER.info("Method called : "+joinPoint.getSignature().getName());
    }

    // Similar to After , we have AfterThrowing ( If exception throws in specified PointCut )
    //  AfterReturning - When specified PointCut execution finishes
    @After("execution(* com.enterprise.app.SpringBootAOPBasics.controller.ApartmentController.*(..))" )
    public void logAfter(JoinPoint joinPoint) {
        LOGGER.info("Method finished Execution : "+joinPoint.getSignature().getName());
    }

    // If the ValidatorAspect is removed, then the below code will works. Else throw exception in
    // divide method, and u will see the below output.
    @AfterThrowing("execution(* com.enterprise.app.SpringBootAOPBasics.controller.ApartmentController.divide(..))")
    public void handleErr(JoinPoint joinPoint) {
        LOGGER.info("Method Crashed : "+joinPoint + "for input : "+ Arrays.toString(joinPoint.getArgs()));
    }
}
