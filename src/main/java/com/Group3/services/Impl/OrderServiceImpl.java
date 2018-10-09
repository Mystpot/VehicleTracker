package com.Group3.services.Impl;

import com.Group3.domain.Orders;
import com.Group3.repositories.OrderRepository;
import com.Group3.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Orders create(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public Optional<Orders> read(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Orders update(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public void delete(Orders id) {
        orderRepository.delete(id);
    }

//    @Override
//    public Orders findByCustomer(long id) {
//        return null;
//    }
}
