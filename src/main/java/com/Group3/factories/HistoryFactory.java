package com.Group3.factories;

import com.Group3.domain.History;
import com.Group3.domain.Invoices;
import com.Group3.domain.Rent;

import java.util.Map;

public class HistoryFactory
{
    public  static History getHistory(Map<String, Boolean> boolValues, Rent rent, Invoices invoices)
    {
        History history = new History.Builder()
                .rented(boolValues.get("rented"))
                .outstanding(boolValues.get("outstanding"))
                .rent(rent)
                .invoices(invoices)
                .build();
        return history;
    }
}

