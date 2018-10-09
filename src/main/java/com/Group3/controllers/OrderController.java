package com.Group3.controllers;

import com.Group3.domain.Customer;
import com.Group3.domain.Orders;
import com.Group3.factories.OrderFactory;
import com.Group3.services.Impl.CustomerServiceImpl;
import com.Group3.services.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/order")
public class OrderController {


    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    OrderServiceImpl orderService;

    private Orders orders;

    private Customer customer;

    private Customer cust2;

    @CrossOrigin
    @PostMapping(path="/{customerId}/addOrder")
    public @ResponseBody
    Orders create(@PathVariable long customerId, @RequestParam String orderDate)
    {
        Optional<Customer> customer = customerService.read(customerId);

        if (customer.isPresent())
        {
            cust2 = customer.get();
        }

        orders = OrderFactory.getOrder(orderDate,cust2);
        return  orderService.create(orders);
    }
    @CrossOrigin
    @GetMapping (path="/{customerId}/findOrder")
    public @ResponseBody ResponseEntity findByCustomer (@PathVariable long customerId, @RequestParam long id)
    {
        Optional <Orders> orders = orderService.read(id);

        if(!orders.isPresent())
        {
            return new ResponseEntity("No order found for customer" + customerId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(orders, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping (path="/{customerId}/updateOrder")
    public @ResponseBody Orders updateOrder (@PathVariable long customerId,@RequestParam long id, @RequestParam String orderDate) {


        orderService.read(id);
        Orders orderUpdate = new Orders.Builder()
                .id(id)
                .orderDate(orderDate)
                .build();

        return orderService.update(orderUpdate);
    }
    @CrossOrigin
    @GetMapping (path="/{customerId}/deleteOrder")
    public @ResponseBody void updateOrder (@RequestParam Orders id) {
        orderService.delete(id);

    }
}
