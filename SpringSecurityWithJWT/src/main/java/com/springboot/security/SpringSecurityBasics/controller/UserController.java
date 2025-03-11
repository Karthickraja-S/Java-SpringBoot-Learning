package com.springboot.security.SpringSecurityBasics.controller;

import com.springboot.security.SpringSecurityBasics.service.CustomUserDetailsService;
import com.springboot.security.SpringSecurityBasics.service.JWTService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.security.SpringSecurityBasics.model.User;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    CustomUserDetailsService service;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTService jwtService;
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
    @PostMapping("/login")
    public String getJWTToken(@RequestBody Map<String,String> request) {
        System.out.println(request);

        String userName = request.get("username");
        String password = request.get("password");
        if(userName != null && password != null) {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userName, password));

            if(authentication.isAuthenticated())
                return jwtService.generateToken(userName);

        }
        return "Login Failed";
    }
}
