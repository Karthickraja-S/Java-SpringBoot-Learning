package com.enterprise.app.SpringBootAppWithJPA_V2.exception;

public class InvalidApartmentDataPassed extends RuntimeException{
    public InvalidApartmentDataPassed(String message) {
        super(message);
    }
}
