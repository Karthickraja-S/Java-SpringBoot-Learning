package com.enterprise.app.SpringBootAppWithJPA_V2.repository;

import com.enterprise.app.SpringBootAppWithJPA_V2.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Integer> {

    // With the help of JpaRepository all the basic CRUD Operations make life easier !
    // But what if you need data like Apartment price < 12,00,000 and like this?
    // a custom query ?


    // We can declare a method findBy<The_Column_Name_Mapped_In_Table><Some_Operations_If_Needed>
    //@Query(value = "select a from apartment a where s.areaLocated=?1")
    // The above Query annotation will automatically appended to the method below. If we need any custom
    // Query to be executed, then we can declare like this :)
    public List<Apartment> findByareaLocated(String areaLocated);
    public List<Apartment> findByratePerFlatLessThanEqual(int price);

}
