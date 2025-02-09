package com.enterprise.app.SpringBootAOPBasics.service;

import com.enterprise.app.SpringBootAOPBasics.model.Apartment;
import com.enterprise.app.SpringBootAOPBasics.repository.ApartmentRepository;
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

    public Apartment addApartment(Apartment apartment) {
        System.out.println("Going to add apartment : "+apartment);
        return repository.save(apartment);
    }

    public Apartment updateApartment(Apartment apartment) {
        System.out.println("Going to update apartment : "+apartment);
        return repository.save(apartment);
    }

    public Apartment getApartment(int id) {
        // Else just return apartment with default values.
        return repository.findById(id).orElse(new Apartment());
    }
    public boolean removeApartment(int id) {
        repository.deleteById(id);
        return true;
    }

    public void populateData() {
        List<Apartment> apartments = List.of(
                new Apartment(1,"Karthick Apartment","Chennai",15,10,1200000),
                new Apartment(2,"Vicky Apartment","Bangalore",20,5,2000000),
                new Apartment(3,"Philo Apartment","Bangalore",10,4,1400000),
                new Apartment(4,"Thanvi Apartment","Madurai",10,4,1000000)
        );
        repository.saveAll(apartments);
    }

    public List<Apartment> getApartment(String area) {
        return repository.findByareaLocated(area);
    }

    public List<Apartment> getApartmentLessThanOrEqualsTo(int price) {
        return repository.findByratePerFlatLessThanEqual(price);
    }
}
