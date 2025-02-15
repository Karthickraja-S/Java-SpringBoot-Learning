package com.springboot.security.SpringSecurityBasics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.security.SpringSecurityBasics.model.Apartment;
import org.springframework.stereotype.Repository;


@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Integer> {

}
