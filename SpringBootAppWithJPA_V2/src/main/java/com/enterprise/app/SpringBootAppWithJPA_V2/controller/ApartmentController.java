package com.enterprise.app.SpringBootAppWithJPA_V2.controller;


import com.enterprise.app.SpringBootAppWithJPA_V2.model.Apartment;
import com.enterprise.app.SpringBootAppWithJPA_V2.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@CrossOrigin( origins = {"http://localhost:3000"})
public class ApartmentController {
    @Autowired
    ApartmentService service;
    // If this class annotated as Controller, then here we have to say @ResponseBody to indicate this method returns Json Data.
    @GetMapping("/apartments")
    public ResponseEntity<?> getAllApartments() {
        return new ResponseEntity<>(service.getAllApartments(), HttpStatus.OK);
    }

    // While testing the below API in postman, choosed form-data and specified content-type too
    // https://stackoverflow.com/questions/50395010/spring-postman-content-type-application-octet-stream-not-supported
    @PostMapping(path = "apartment")
    public ResponseEntity<?> saveApartments(@RequestPart Apartment apartment , @RequestPart MultipartFile image) throws IOException {
            return new ResponseEntity<>(service.addOrUpdateApartment(apartment,image),HttpStatus.CREATED);
    }
    @PutMapping("apartment")
    public ResponseEntity<?> updateApartments(@RequestPart Apartment apartment, @RequestPart MultipartFile image) throws IOException{
            return new ResponseEntity<>(service.addOrUpdateApartment(apartment,image),HttpStatus.CREATED);
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
    public ResponseEntity<Apartment> getApartmentById(@PathVariable int id) {
        Apartment apartment = service.getApartment(id);
        if(apartment.getId() != -1) {
            return new ResponseEntity<>(apartment, HttpStatus.OK);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }
    @DeleteMapping("apartment/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable int id) {
        boolean res = service.removeApartment(id);
        if(res) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(NOT_FOUND);
    }
}
