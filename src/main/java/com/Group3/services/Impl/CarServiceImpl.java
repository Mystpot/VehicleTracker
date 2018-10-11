package com.Group3.services.Impl;

import com.Group3.domain.Car;
import com.Group3.domain.Category;
import com.Group3.repositories.CarRepository;
import com.Group3.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> read(long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Car id) {
        carRepository.delete(id);
    }

    //function to read all cars in the database and print to table
    @Override
    public Iterable<Car> readAll() {
        return carRepository.findAll();
    }


    //function to read all cars based on the category
    @Override
    public Iterable<Car> findAllById(Category category) {

        return carRepository.findAllById(category);
    }

    @Override
    public Car findByCustomerId(int customerId)
    {
        return carRepository.findByCustomerId(customerId);
    }


}
