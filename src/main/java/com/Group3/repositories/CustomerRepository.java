package com.Group3.repositories;

import com.Group3.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findByEmail(String email);
}