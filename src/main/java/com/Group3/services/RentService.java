package com.Group3.services;

import com.Group3.domain.Rent;

import java.util.Optional;

public interface RentService
{
    Rent create(Rent rent);
    Optional<Rent> readById(int id);
    Rent update(Rent rent);
    void delete(Rent id);
    Iterable<Rent> readAll();
    Iterable<Rent> findAllByCustomerId(int customerId);
    Rent findCustomerId(int customerId);
}