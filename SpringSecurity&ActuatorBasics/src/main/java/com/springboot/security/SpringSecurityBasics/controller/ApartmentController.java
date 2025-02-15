package com.springboot.security.SpringSecurityBasics.controller;



import com.springboot.security.SpringSecurityBasics.model.Apartment;
import com.springboot.security.SpringSecurityBasics.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin( origins = {"http://localhost:3000"})
public class ApartmentController {
    @Autowired
    ApartmentService service;
    @GetMapping("/apartments")
    public List<Apartment> getAllApartments() {
        return service.getAllApartments();
    }

}
