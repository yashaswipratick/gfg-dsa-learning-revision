package com.revision.topics.lld.car_rental.strategy_pattern.strategy;

import com.revision.topics.lld.car_rental.Car;

public class HatchPricingStrategy implements PricingStrategy {
    @Override
    public long calculatePrice(Car car) {
        return 2000;
    }
}
