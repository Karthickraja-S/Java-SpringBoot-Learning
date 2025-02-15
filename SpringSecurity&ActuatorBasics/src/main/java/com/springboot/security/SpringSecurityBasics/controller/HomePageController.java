package com.springboot.security.SpringSecurityBasics.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String getHomePage() {
        System.out.println("In homepage controller...");
        return "homepage.html";
    }

    /**
     * CSRF token used to hit request from an unknown source like postman, other servers
     */
    @GetMapping("/getcsrftoken")
    @ResponseBody
    public CsrfToken crsfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("/hello")
    @ResponseBody
    public String crsfToken() {
        return "Hello Buddy! This is an unauthenticated API.. :)";
    }
}
