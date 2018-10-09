package com.Group3.factories;

import com.Group3.domain.Car;
import com.Group3.domain.Orders;
import com.Group3.domain.Rent;

import java.math.BigDecimal;

public class RentFactory
{
    public static Rent getRent(Car car, String rentDate, String returnDate, BigDecimal totalPrice,
                               Orders order, int rentalDays, boolean outstanding)
    {
        Rent rent = new Rent.Builder()
                .car(car)
                .rentDate(rentDate)
                .returntDate(returnDate)
                .rentalDays(rentalDays)
                .totalPrice(totalPrice)
                .order(order)
                .outstanding(outstanding)
                .build();
        return  rent;
    }
}
