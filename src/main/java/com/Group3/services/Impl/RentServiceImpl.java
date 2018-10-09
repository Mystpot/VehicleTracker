package com.Group3.services.Impl;

import com.Group3.domain.Rent;
import com.Group3.repositories.RentRepository;
import com.Group3.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RentServiceImpl implements RentService
{
    @Autowired
    private RentRepository rentRepository;


    @Override
    public Rent create(Rent rent) {

        return rentRepository.save(rent);
    }

    @Override
    public Optional<Rent> read(long id) {
        return rentRepository.findById(id);
    }

    @Override
    public Rent update(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public void delete(Rent id) {
        rentRepository.delete(id);
    }

    @Override
    public Iterable<Rent> readAll() {
        return rentRepository.findAll();
    }

    @Override
    public Iterable<Rent> findAllById(long id) {
        return rentRepository.findAllById(id);
    }
}

