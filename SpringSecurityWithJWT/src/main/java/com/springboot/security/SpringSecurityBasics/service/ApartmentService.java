package com.springboot.security.SpringSecurityBasics.service;

import com.springboot.security.SpringSecurityBasics.model.Apartment;
import com.springboot.security.SpringSecurityBasics.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApartmentService {
    @Autowired
    ApartmentRepository repository;
    public List<Apartment> getAllApartments() {
        return repository.findAll();
    }

}
