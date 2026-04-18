package com.revision.topics.lld.car_rental.strategy_pattern.strategy;

import com.revision.topics.lld.car_rental.Car;

public interface PricingStrategy {
    long calculatePrice(Car car);
}
