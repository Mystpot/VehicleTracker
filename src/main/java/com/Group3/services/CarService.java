package com.Group3.services;

import com.Group3.domain.Car;
import com.Group3.domain.Category;

import java.util.Optional;

public interface CarService {
    Car create(Car car);
    Optional<Car> read(long id);
    Car update(Car car);
    void delete(Car id);

    //function to read all cars in the database and print to table
    Iterable<Car> readAll();

    //function to read all cars based on the category
    Iterable<Car> findAllById(Category category);

    Car findByCustomerId(int customerId);
}