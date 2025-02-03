package com.enterprise.app.SpringBootAppDBIntro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Apartment {
    public Apartment(int id, String name, String areaLocated, int noOfFlatsAvailable, int noOfFlatsSold, int ratePerFlat) {
        this.id = id;
        this.name = name;
        this.areaLocated = areaLocated;
        this.noOfFlatsAvailable = noOfFlatsAvailable;
        this.noOfFlatsSold = noOfFlatsSold;
        this.ratePerFlat = ratePerFlat;
    }

    // as of now used this property,
    // while full flexing the project, need to consider price variant like top floor , first floor , and
    // also main area is Chennai , and inside we may have many apartments in further places inside chennai !
    // sp, finally we need to consider all those stuff.! and this pkg is just learning :)
    private int id;
    private String name;
    private String areaLocated;
    private int noOfFlatsAvailable;
    private int noOfFlatsSold;
    private int ratePerFlat;

}
