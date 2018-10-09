package com.Group3.services;

import com.Group3.domain.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer create(Customer customer);
    Optional<Customer> read(long id);
    Customer update(Customer customer);
    void delete(Customer id);
    Iterable<Customer> findAll();
    Customer availableEmail(String email);
}
