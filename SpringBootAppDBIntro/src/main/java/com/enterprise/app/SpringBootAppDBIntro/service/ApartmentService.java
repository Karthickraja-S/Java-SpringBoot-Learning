package com.enterprise.app.SpringBootAppDBIntro.service;

import com.enterprise.app.SpringBootAppDBIntro.model.Apartment;
import com.enterprise.app.SpringBootAppDBIntro.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApartmentService {
    @Autowired
    ApartmentRepository repository;
    public List<Apartment> getAllApartments() {
        return repository.getAllApartments();
    }

    public boolean addApartment(Apartment apartment) {
        System.out.println("Going to add apartment : "+apartment);
        return repository.addApartment(apartment);
    }

    public boolean updateApartment(Apartment apartment) {
        System.out.println("Going to update apartment : "+apartment);
        return repository.updateApartment(apartment);
    }

    public Apartment getApartment(int id) {
        return repository.getApartment(id);
    }

    public boolean removeApartment(int id) {
        return repository.removeApartment(id);
    }
}
