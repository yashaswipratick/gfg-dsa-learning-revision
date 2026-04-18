package com.revision.topics.lld.car_rental;

import java.util.*;

import static com.revision.topics.lld.car_rental.Utility.*;

// implement strategy Pattern using Price Filters
public class SearchCars {

    /*Map<String, List<Car>> carDetails;

    public SearchCars() {
        carDetails = new ConcurrentHashMap<>();
        carDetails.putAll(generateCarDetailsDataMap());
    }*/

    //Price Filter
    public List<Car> searchCarWithFilter(PriceFilter filter) {
        //sort in ascending based on base price
        List<Car> carList = new ArrayList<>(carDetails.values()
                .stream()
                .flatMap(List::stream)
                .toList());

        carList.sort(Comparator.comparingLong(Car::getBasePrice));
        //return all cars details in sorted order
        return carList;
    }

    public List<Car> searchCarWithCarModel(String model) {
        List<Car> cars1 = carDetails.get(model);
        List<Car> cars= new ArrayList<>();
        for (int i = 0; i < cars1.size(); i++) {
            if (model.equalsIgnoreCase(cars1.get(i).getModel())) {
                cars.add(cars1.get(i));
            }
        }
        return cars;
    }

    public List<Car> searchCarBasedOnLocation(String locationDetails) {
        List<Car> carList = new ArrayList<>(carDetails.values()
                .stream()
                .flatMap(List::stream)
                .toList());
        List<Car> list = new ArrayList<>();
        for (Car car : carList) {
            if (locationDetails.equalsIgnoreCase(car.getLocation())){
                list.add(car);
            }
        }
        return list;
    }
}
