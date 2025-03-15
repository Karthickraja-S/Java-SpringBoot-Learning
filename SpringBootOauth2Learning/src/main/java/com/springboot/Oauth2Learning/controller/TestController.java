package com.springboot.Oauth2Learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
    @GetMapping("/unauth-api")
    public String helloUnAuth() {
        // here we can have a login page and a google symbol which redirected to
        // http://localhost:8080/oauth2/authorization/google
        return "Hello world From UnAuth API";
    }
}
