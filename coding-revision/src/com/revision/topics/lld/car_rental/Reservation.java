package com.revision.topics.lld.car_rental;

import com.revision.topics.lld.car_rental.strategy_pattern.factory.PricingFactory;
import com.revision.topics.lld.car_rental.strategy_pattern.strategy.CarType;
import com.revision.topics.lld.car_rental.strategy_pattern.strategy.HatchPricingStrategy;
import com.revision.topics.lld.car_rental.strategy_pattern.strategy.PricingStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.revision.topics.lld.car_rental.Utility.carDetails;

// implement Command Patterns
public class Reservation {

    //Map<String, List<Car>> carDetails;
    Map<String, Rental> rentalDetails;

    public Reservation() {
        rentalDetails = new ConcurrentHashMap<>();
    }

    public Rental reserve(String carId, String CustomerId, LocalDate startDate, LocalDate endDate) {
        List<Car> cars = carDetails.get("SEDAN");
        Car car = cars.get(0);

        // Use Build Pattern
        Rental rental = new Rental();
        rental.setId(String.valueOf(UUID.randomUUID()));
        rental.setBookingId(String.valueOf(UUID.randomUUID()));
        PricingStrategy pricingStrategy = PricingFactory.getInstance(CarType.valueOf(car.getModel()));
        rental.setPrice(pricingStrategy.calculatePrice(car));
        rental.setStatus(RentalStatus.RESERVED);
        rental.setCarId(car.getId());
        rentalDetails.put(rental.getId(), rental);
        synchronized (car) {
            Integer availability = car.getAvailability();
            car.setAvailability(--availability);
        }
        int i = cars.indexOf(car);
        cars.set(i, car);
        carDetails.put(car.getModel(), cars);
        return rental;
    }

    public Long decidePrice(Car car) {

        if (car.getUsage() != null && car.getUsage() > 10) {
            return car.getBasePrice() * 2;
        }
        return car.getBasePrice();
    }

    public Rental cancel(String rentalId, String modelType) {
        Rental rental = rentalDetails.get(rentalId);
        List<Car> carList = carDetails.get(modelType);
        Car car = null;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getId().equalsIgnoreCase(rental.getCarId())) {
                car = carList.get(i);
            }
        }
        synchronized (car) {
            Integer availability = car.getAvailability();
            car.setAvailability(++availability);
        }
        rental.setStatus(RentalStatus.CANCELLED);
        int i = carList.indexOf(car);
        carList.set(i, car);
        carDetails.put(car.getModel(), carList);
        rentalDetails.put(rental.getId(), rental);
        return rental;
    }
}
