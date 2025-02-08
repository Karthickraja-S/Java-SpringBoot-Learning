package com.enterprise.app.SpringBootAppWithJPA_V2.util;

import com.enterprise.app.SpringBootAppWithJPA_V2.model.Apartment;
import org.springframework.stereotype.Component;

@Component
public class ApartmentUtil {
    public boolean validate(Apartment apartment) {
        return apartment.getNoOfFlatsAvailable() > 0 &&
                apartment.getNoOfFlatsAvailable() >= apartment.getNoOfFlatsSold() &&
                apartment.getNoOfFlatsSold() > 0 &&
                apartment.getRatePerFlat() > 0 &&
                apartment.getId() > 0;
    }
}
