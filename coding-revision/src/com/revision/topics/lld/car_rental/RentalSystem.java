package com.revision.topics.lld.car_rental;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class RentalSystem {

    //CAR Rental System

    // 1. Customer can search for Cars
    // 2. Rent the car
    // 3. Pay for the amount which he rented car.
    // 4. cancel the booking
    // 5. Pricing rules depends on car, day location, usage of the car
    // 6. consistency in our application -> strong consistency
    // 7. concurrency can be handled -> Race condition should be handled


    //Service classes

    //1. api - booking/Reservation - id, sd, ed, customerID
    //2. api - cancel
    //3. api - payment -> credit and debit
    //4. api - Rules ->
    //         sort low to high
    //          Type of car
    //          Locations -> lat long


    public static void main(String[] args) {
        SearchCars searchCars = new SearchCars();

        Utility.generateCarDetailsDataMap();
        List<Car> xuv = searchCars.searchCarWithCarModel("SEDAN");
        if (!xuv.isEmpty()) {
            System.out.println("Search Available " + xuv);
        } else {
            System.out.println("No cars found");
        }

        Reservation reserveCar = new Reservation();
        Rental reserve = reserveCar.reserve(xuv.get(0).getId(), "1", LocalDate.now(), LocalDate.now().plusDays(2));
        if (reserve != null) {
            System.out.println(" Reservation successful. "  + reserve);
        } else {
            System.out.println("No cars available...");
        }

        List<Car> xuv1 = searchCars.searchCarWithCarModel("XUV");
        if (!xuv.isEmpty()) {
            System.out.println("Search Available after booking" + xuv1);
        } else {
            System.out.println("No cars found");
        }

        Rental cancelled = reserveCar.cancel(reserve.getId(), "SEDAN");
        if (cancelled != null) {
            System.out.println("Cancelled booking" + cancelled.getBookingId());
        } else {
            System.out.println("Booking not found...");
        }

        List<Car> xuv2 = searchCars.searchCarWithCarModel("XUV");
        if (!xuv2.isEmpty()) {
            System.out.println("Search Available after booking" + xuv2);
        } else {
            System.out.println("No cars found");
        }
    }

}
