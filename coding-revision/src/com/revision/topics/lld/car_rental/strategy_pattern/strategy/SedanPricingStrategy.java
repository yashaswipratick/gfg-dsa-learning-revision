package com.revision.topics.lld.car_rental.strategy_pattern.strategy;

import com.revision.topics.lld.car_rental.Car;

public class SedanPricingStrategy implements PricingStrategy {
    @Override
    public long calculatePrice(Car car) {
        return 3000;
    }
}
