package com.enterprise.app.SpringBootAppDBIntro.controller;

import com.enterprise.app.SpringBootAppDBIntro.model.Apartment;
import com.enterprise.app.SpringBootAppDBIntro.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApartmentController {
    @Autowired
    ApartmentService service;
    // If this class annotated as Controller, then here we have to say @ResponseBody to indicate this method returns Json Data.
    @GetMapping("/apartments")
    public List<Apartment> getAllApartments() {
        return service.getAllApartments();
    }
    @PostMapping(path = "apartment" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    // Only accepts json type in BODY. Not XML !
    public boolean saveApartments(@RequestBody Apartment apartment) {
        return service.addApartment(apartment);
    }
    @PutMapping("apartment")
    public boolean updateApartments(@RequestBody Apartment apartment) {
        return service.updateApartment(apartment);
    }
    @GetMapping("apartment/{id}")
    public Apartment getApartmentById(@PathVariable int id) {
        return service.getApartment(id);
    }
    @DeleteMapping("apartment/{id}")
    public boolean deleteApartment(@PathVariable int id) {
        return service.removeApartment(id);
    }
}
