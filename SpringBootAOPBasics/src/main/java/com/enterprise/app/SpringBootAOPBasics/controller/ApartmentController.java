package com.enterprise.app.SpringBootAOPBasics.controller;


import com.enterprise.app.SpringBootAOPBasics.model.Apartment;
import com.enterprise.app.SpringBootAOPBasics.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Access to XMLHttpRequest at 'http://localhost:8080/apartments' from origin
// 'http://localhost:3000' has been blocked by CORS policy: No 'Access-Control-Allow-Origin'
// header is present on the requested resource.
@RestController
@CrossOrigin( origins = {"http://localhost:3000"})
public class ApartmentController {
    @Autowired
    ApartmentService service;
    // If this class annotated as Controller, then here we have to say @ResponseBody to indicate this method returns Json Data.
    @GetMapping("/apartments")
    public List<Apartment> getAllApartments() {
        return service.getAllApartments();
    }
    @PostMapping(path = "apartment" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    // Only accepts json type in BODY. Not XML ! If it is the data we are receiving from a form, then consumes needs
    // to be altered accordingly.
    public Apartment saveApartments(@RequestBody Apartment apartment) {
        return service.addApartment(apartment);
    }
    @PutMapping("apartment")
    public Apartment updateApartments(@RequestBody Apartment apartment) {
        return service.updateApartment(apartment);
    }
    @GetMapping("/apartment/searchByArea/{area}")
    public List<Apartment> getApartmentByArea(@PathVariable String area) {
        return service.getApartment(area);
    }
    @GetMapping("/apartment/priceLessThan/{price}")
    public List<Apartment> getApartmentByPrice(@PathVariable int price) {
        return service.getApartmentLessThanOrEqualsTo(price);
    }
    @GetMapping("apartment/{id}")
    public Apartment getApartmentById(@PathVariable int id) {
        return service.getApartment(id);
    }
    @DeleteMapping("apartment/{id}")
    public boolean deleteApartment(@PathVariable int id) {
        return service.removeApartment(id);
    }

    @GetMapping("apartment/populate")
    public boolean populateData() {
        service.populateData();
        return true;
    }
    @GetMapping("/math/{num}")
    public int divide(@PathVariable int num) {
        return 10/num;
    }
}
