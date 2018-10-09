package com.Group3.factories;

import com.Group3.domain.Customer;
import com.Group3.domain.Orders;

public class OrderFactory {

    public static Orders getOrder(String orderDate, Customer customer ) {

        Orders orders = new Orders.Builder()
                .customer(customer)
                .orderDate(orderDate)
                .build();
        return orders;
    }
}
