package com.Group3.services.Impl;

import com.Group3.domain.Invoices;
import com.Group3.repositories.InvoiceRepository;
import com.Group3.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InvoiceServiceImpl implements InvoiceService
{

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoices create(Invoices invoices)
    {
        return  invoiceRepository.save(invoices);
    }

    public Optional<Invoices> read(long id)
    {
        return invoiceRepository.findById(id);
    }

    public Invoices update(Invoices invoices)
    {
        return invoiceRepository.save(invoices);
    }

    public void delete(Invoices id)
    {
        invoiceRepository.delete(id);
    }

    public Iterable<Invoices> findAll()
    {
        return  invoiceRepository.findAll();
    }


}
