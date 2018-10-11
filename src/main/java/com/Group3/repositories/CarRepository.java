package com.Group3.repositories;

import com.Group3.domain.Car;
import com.Group3.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    Iterable<Car> findAllById(Category category);
    Car findCarsById(Long id);
    Car findByCustomerId(int customerId);
}
