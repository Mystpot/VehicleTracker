package com.Group3.factories;

import com.Group3.domain.Car;
import com.Group3.domain.Category;

import java.util.Map;

public class CarFactory {
    public static Car getCar(Category category, Map<String, String> stringValues, int year, boolean status)
    {
        Car car = new Car.Builder()
                .make(stringValues.get("make"))
                .model(stringValues.get("model"))
                .numberPlate(stringValues.get("numberPlate"))
                .status(status)
                .year(year)
                .category(category)
                .build();
        return car;
    }
}
