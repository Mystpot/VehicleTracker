package com.Group3.repositories;

import com.Group3.domain.Invoices;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoices, Long>
{
    //Iterable<Rent> findAllById(long id);
}