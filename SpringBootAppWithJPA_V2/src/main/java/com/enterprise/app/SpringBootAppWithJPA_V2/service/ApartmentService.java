package com.enterprise.app.SpringBootAppWithJPA_V2.service;

import com.enterprise.app.SpringBootAppWithJPA_V2.exception.InvalidApartmentDataPassed;
import com.enterprise.app.SpringBootAppWithJPA_V2.model.Apartment;
import com.enterprise.app.SpringBootAppWithJPA_V2.repository.ApartmentRepository;
import com.enterprise.app.SpringBootAppWithJPA_V2.util.ApartmentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ApartmentService {
    @Autowired
    ApartmentRepository repository;
    @Autowired
    ApartmentUtil util;
    public List<Apartment> getAllApartments() {
        return repository.findAll();
    }

    public Apartment addOrUpdateApartment(Apartment apartment, MultipartFile image) throws IOException {
        System.out.println("Going to add/update apartment : "+apartment);
        if( (!util.validate(apartment)) || image == null ) {
            throw new InvalidApartmentDataPassed("Please check the inputs you have given..");
        }
        apartment.setImage(image.getBytes());
        apartment.setImageName(image.getOriginalFilename());
        apartment.setImageType(image.getContentType());

        return repository.save(apartment);
    }
    public Apartment getApartment(int id) {
        // Else just return apartment with default values.
        return repository.findById(id).orElse(new Apartment(-1));
    }
    public boolean removeApartment(int id) {
        repository.deleteById(id);
        // validate ID if needed.
        return true;
    }
    public List<Apartment> getApartment(String area) {
        return repository.findByareaLocated(area);
    }

    public List<Apartment> getApartmentLessThanOrEqualsTo(int price) {
        return repository.findByratePerFlatLessThanEqual(price);
    }
}
