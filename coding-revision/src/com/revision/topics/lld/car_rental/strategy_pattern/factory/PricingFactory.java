package com.revision.topics.lld.car_rental.strategy_pattern.factory;

import com.revision.topics.lld.car_rental.Car;
import com.revision.topics.lld.car_rental.strategy_pattern.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class PricingFactory {

    static Map<CarType, PricingStrategy> map = new HashMap<>();

    static {
        map.put(CarType.XUV, new XUVPricingStrategy());
        map.put(CarType.SEDAN, new SedanPricingStrategy());
        map.put(CarType.HATCHBACK, new HatchPricingStrategy());
    }

    public static PricingStrategy getInstance(CarType carType) {
        return map.get(carType);
    }
}
