package com.enterprise.app.SpringBootAppWithJPA_V2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
// The below one denotes that we have a table Apartment in DataBase. What if the table name and class varies?
// we have to use @Table annotation and need to specify the name inside the annotation.
@Entity
public class Apartment {
    public Apartment(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaLocated() {
        return areaLocated;
    }

    public void setAreaLocated(String areaLocated) {
        this.areaLocated = areaLocated;
    }

    public int getNoOfFlatsAvailable() {
        return noOfFlatsAvailable;
    }

    public void setNoOfFlatsAvailable(int noOfFlatsAvailable) {
        this.noOfFlatsAvailable = noOfFlatsAvailable;
    }

    public int getNoOfFlatsSold() {
        return noOfFlatsSold;
    }

    public void setNoOfFlatsSold(int noOfFlatsSold) {
        this.noOfFlatsSold = noOfFlatsSold;
    }

    public int getRatePerFlat() {
        return ratePerFlat;
    }

    public void setRatePerFlat(int ratePerFlat) {
        this.ratePerFlat = ratePerFlat;
    }
    public byte[] getImage() {return image;}
    public void setImage(byte[] image) {this.image = image;}
    public void setImageType(String imageType){this.imageType = imageType;}
    public void setImageName(String imageName){this.imageName=imageName;}
    public String getImageType(){return imageType;}
    public String getImageName(){return imageName;}

    public Apartment(int id, String name, String areaLocated, int noOfFlatsAvailable, int noOfFlatsSold, int ratePerFlat, byte[] image,String imageName,String imageType ) {
        this.id = id;
        this.name = name;
        this.areaLocated = areaLocated;
        this.noOfFlatsAvailable = noOfFlatsAvailable;
        this.noOfFlatsSold = noOfFlatsSold;
        this.ratePerFlat = ratePerFlat;
        this.image = image;
        this.imageName = imageName;
        this.imageType = imageType;
    }

    public Apartment(int id, String name, String areaLocated, int noOfFlatsAvailable, int noOfFlatsSold, int ratePerFlat) {
        this.id = id;
        this.name = name;
        this.areaLocated = areaLocated;
        this.noOfFlatsAvailable = noOfFlatsAvailable;
        this.noOfFlatsSold = noOfFlatsSold;
        this.ratePerFlat = ratePerFlat;
    }
    public Apartment(){}

    // The @Id denotes that id is the primary Key for table Apartment.
    // If the column name is different in DB, then @Column Can be used to map. @Column(name = "<NAME_IN_DB>")
    @Id
    private int id;
    private String name;
    private String areaLocated;
    private int noOfFlatsAvailable;
    private int noOfFlatsSold;
    private int ratePerFlat;

    @Lob
    private byte[] image;
    private String imageName;
    private String imageType;

}
