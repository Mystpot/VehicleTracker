package com.Group3.repositories;

import com.Group3.domain.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long>
{
    Iterable<Rent> findAllById(long id);

}
