package com.Group3.factories;

import com.Group3.domain.Customer;

import java.util.Map;

public class CustomerFactory
{
    public static Customer getCustomer(Map<String, String> stringValues, Map<String,Integer> intValues)
    {
        Customer customer = new Customer.Builder()
                .name(stringValues.get("name"))
                .surname(stringValues.get("surname"))
                .email(stringValues.get("email"))
                .city(stringValues.get("city"))
                .province(stringValues.get("province"))
                .complex(stringValues.get("complex"))
                .street(stringValues.get("street"))
                .houseNumber(intValues.get("houseNumber"))
                .postalCode(intValues.get("postalCode"))
                //.invoices(invoices)
                .build();
        return customer;
    }

}
