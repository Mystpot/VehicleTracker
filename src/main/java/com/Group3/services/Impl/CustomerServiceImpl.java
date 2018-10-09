package com.Group3.services.Impl;

import com.Group3.domain.Customer;
import com.Group3.repositories.CustomerRepository;
import com.Group3.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> read(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer id) {
        customerRepository.delete(id);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer availableEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
