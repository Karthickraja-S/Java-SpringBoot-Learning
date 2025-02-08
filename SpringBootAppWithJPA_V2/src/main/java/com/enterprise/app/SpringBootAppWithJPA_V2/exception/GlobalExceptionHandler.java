package com.enterprise.app.SpringBootAppWithJPA_V2.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception e , HttpServletRequest request) {
        // If i give string instead of num for {id} pathParam, then exception will not reach here.
        // only the exception that we throw from the API Controllers will come here
        System.out.println("---------- Generic Exception ----------------");
        e.printStackTrace();
        ExceptionMsg msg = new ExceptionMsg(LocalDate.now(),e.getMessage(),request.getServletPath());
        return new ResponseEntity<>(msg , HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidApartmentDataPassed.class)
    public ResponseEntity<?> handleInvalidApartmentExceptions(Exception e , HttpServletRequest request) {
        // If we put try catch in controller class itself, then spring will not handle here.
        // if we leave controlling exception to spring itself only , then throwing exception will come here
        // and we can handle the exceptions effectively :)
        ExceptionMsg msg = new ExceptionMsg(LocalDate.now(),e.getMessage(),request.getServletPath());
        return new ResponseEntity<>(msg , HttpStatus.BAD_REQUEST);
    }
}
