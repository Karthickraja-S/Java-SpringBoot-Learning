package com.enterprise.app.SpringBootAppDBIntro.repository;

import com.enterprise.app.SpringBootAppDBIntro.model.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApartmentRepository {
    @Autowired
    JdbcTemplate template;

    public List<Apartment> getAllApartments() {
        String selQ = "SELECT * from APARTMENT";
        List<Apartment> apartments = new ArrayList<>();
         template.query(selQ , x -> {
             try {
                 Apartment apartment = new Apartment();
                 apartment.setId(x.getInt("ID"));
                 apartment.setName(x.getString("NAME"));
                 apartment.setAreaLocated(x.getString("AREALOCATED"));
                 apartment.setNoOfFlatsAvailable(x.getInt("NOOFFLATSAVAILABLE"));
                 apartment.setNoOfFlatsSold(x.getInt("NOOFFLATSSOLD"));
                 apartment.setRatePerFlat(x.getInt("RATEPERFLAT"));
                 apartments.add(apartment);
             } catch (Exception e) {
                e.printStackTrace();
             }
        });
         return apartments;
    }

    public boolean addApartment(Apartment apartment) {
        String insertQ = "INSERT INTO APARTMENT(name,areaLocated,noOfFlatsAvailable,ratePerFlat) VALUES(?,?,?,?)";
        return template.update(insertQ , apartment.getName() , apartment.getAreaLocated() , apartment.getNoOfFlatsAvailable()
        , apartment.getRatePerFlat()) == 1;
    }

    public boolean updateApartment(Apartment apartment) {
        String updateQ = "UPDATE APARTMENT SET name=?,areaLocated=?,noOfFlatsAvailable=?,noOfFlatsSold=?,ratePerFlat=? where id=?";
        return template.update(updateQ , apartment.getName(),apartment.getAreaLocated(),apartment.getNoOfFlatsAvailable(),
                apartment.getNoOfFlatsSold(),apartment.getNoOfFlatsSold(),apartment.getId()) == 1;
    }

    public Apartment getApartment(int id) {
        String selQ = "SELECT * from APARTMENT where id = ?";
        List<Apartment> apartments = new ArrayList<>();
        template.query(selQ , x -> {
            try {
                Apartment apartment = new Apartment();
                apartment.setId(x.getInt("ID"));
                apartment.setName(x.getString("NAME"));
                apartment.setAreaLocated(x.getString("AREALOCATED"));
                apartment.setNoOfFlatsAvailable(x.getInt("NOOFFLATSAVAILABLE"));
                apartment.setNoOfFlatsSold(x.getInt("NOOFFLATSSOLD"));
                apartment.setRatePerFlat(x.getInt("RATEPERFLAT"));
                apartments.add(apartment);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } , id);
        return apartments.size() > 0 ? apartments.get(0) : null;
    }

    public boolean removeApartment(int id) {
        String deleteQ = "DELETE FROM APARTMENT WHERE ID = ?";
        return template.update(deleteQ , id) == 1;
    }
}
