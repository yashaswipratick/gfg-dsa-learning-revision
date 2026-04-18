package com.revision.topics.lld.car_rental;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Utility {
    static Map<String, List<Car>> carDetails = new ConcurrentHashMap<>();

    public static Map<String, List<Car>>  generateCarDetailsDataMap() {
        Car xuv = new Car();
        xuv.setId(String.valueOf(UUID.randomUUID()));
        xuv.setAvailability(5);
        xuv.setKilometers(2000L);
        xuv.setFuelCapacity(44);
        xuv.setLaunchYear(2024);
        xuv.setMileage(15);
        xuv.setMode(String.valueOf(Mode.AUTOMATIC));
        xuv.setModel("XUV");
        xuv.setBasePrice(5000L);
        xuv.setLocation("Hyderabad");
        xuv.setName("3XO");
        xuv.setSeats(5);
        List<Car> car = new ArrayList<>();
        car.add(xuv);
        carDetails.put(xuv.getModel(), car);

        Car mahindraXuv = new Car();
        mahindraXuv.setId(String.valueOf(UUID.randomUUID()));
        mahindraXuv.setAvailability(5);
        mahindraXuv.setKilometers(1000L);
        mahindraXuv.setFuelCapacity(44);
        mahindraXuv.setLaunchYear(2025);
        mahindraXuv.setMileage(15);
        mahindraXuv.setMode(String.valueOf(Mode.AUTOMATIC));
        mahindraXuv.setModel("XUV");
        mahindraXuv.setBasePrice(10000L);
        mahindraXuv.setLocation("Hyderabad");
        mahindraXuv.setName("scorpio");
        mahindraXuv.setSeats(5);
        car.add(mahindraXuv);
        carDetails.putIfAbsent(mahindraXuv.getModel(), car);

        Car sedan = new Car();
        sedan.setId(String.valueOf(UUID.randomUUID()));
        sedan.setAvailability(5);
        sedan.setKilometers(20000L);
        sedan.setFuelCapacity(44);
        sedan.setLaunchYear(2025);
        sedan.setMileage(15);
        sedan.setMode(String.valueOf(Mode.AUTOMATIC));
        sedan.setModel("SEDAN");
        sedan.setBasePrice(3000L);
        sedan.setLocation("Bangalore");
        sedan.setName("City");
        sedan.setSeats(5);
        List<Car> carSedan = new ArrayList<>();
        carSedan.add(sedan);
        carDetails.put(sedan.getModel(), carSedan);

        Car hatchback = new Car();
        hatchback.setId(String.valueOf(UUID.randomUUID()));
        hatchback.setAvailability(5);
        hatchback.setKilometers(2000L);
        hatchback.setFuelCapacity(44);
        hatchback.setLaunchYear(2024);
        hatchback.setMileage(15);
        hatchback.setMode(String.valueOf(Mode.AUTOMATIC));
        hatchback.setModel("HATCHBACK");
        hatchback.setBasePrice(1500L);
        hatchback.setLocation("Delhi");
        hatchback.setName("Waganor");
        hatchback.setSeats(5);
        List<Car> carHatchBack = new ArrayList<>();
        carHatchBack.add(hatchback);
        carDetails.put(hatchback.getModel(), carHatchBack);
        return carDetails;
    }
}
