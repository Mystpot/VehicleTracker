package com.Group3.services;

import com.Group3.domain.Orders;

import java.util.Optional;

public interface OrderService {

    Orders create(Orders orders);
    Optional<Orders> read(long id);
    Orders update(Orders orders);
    void delete(Orders id);
    //Orders findByCustomer(Long id);
}