package com.Group3.factories;

import com.Group3.domain.Car;
import com.Group3.domain.Customer;
import com.Group3.domain.Orders;
import com.Group3.domain.Rent;

import java.math.BigDecimal;

public class RentFactory
{
    public static Rent getRent(String rentDate, String returnDate, BigDecimal totalPrice,
                               int rentalDays, boolean outstanding, int customerId )
    {
        Rent rent = new Rent.Builder()
                .rentDate(rentDate)
                .returntDate(returnDate)
                .rentalDays(rentalDays)
                .totalPrice(totalPrice)
                .customerId(customerId)
                .outstanding(outstanding)
                .build();
        return  rent;
    }
}
