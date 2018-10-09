package com.Group3.services;

import com.Group3.domain.Invoices;

import java.util.Optional;

public interface InvoiceService
{
    Invoices create(Invoices invoices);
    Optional<Invoices> read(long id);
    Invoices update(Invoices invoices);
    void delete(Invoices id);
    Iterable<Invoices> findAll();
}

