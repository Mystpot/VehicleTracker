package com.Group3.factories;

import com.Group3.domain.Customer;
import com.Group3.domain.Invoices;

public class InvoiceFactory
{
    public  static Invoices getInvoice(Customer customer)
    {
        Invoices invoices = new Invoices.Builder()
                .customer(customer)
                .build();
        return invoices;
    }
}
