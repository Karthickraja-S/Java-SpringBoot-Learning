package com.springboot.security.SpringSecurityBasics.controller;

import com.springboot.security.SpringSecurityBasics.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.security.SpringSecurityBasics.model.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    CustomUserDetailsService service;
    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
    //    System.out.println("Going to save user => "+user);
        service.saveUser(user);
        return user;
    }
    @GetMapping("/users")
    public List<User> getAllUser() {
        return service.getAllUsers();
    }
}
