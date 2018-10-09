package com.Group3.services;

import com.Group3.domain.Rent;

import java.util.Optional;

public interface RentService
{
    Rent create(Rent rent);
    Optional<Rent> read(long id);
    Rent update(Rent rent);
    void delete(Rent id);
    Iterable<Rent> readAll();
    Iterable<Rent> findAllById(long id);
}