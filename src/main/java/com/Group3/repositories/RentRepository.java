package com.Group3.repositories;

import com.Group3.domain.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Integer>
{
    Iterable<Rent> findAllByCustomerId(int customerId);

    Rent findByCustomerId(int customerId);

}
