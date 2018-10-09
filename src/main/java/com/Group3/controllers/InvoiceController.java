package com.Group3.controllers;

import com.Group3.domain.Customer;
import com.Group3.domain.Invoices;
import com.Group3.factories.InvoiceFactory;
import com.Group3.services.Impl.CustomerServiceImpl;
import com.Group3.services.Impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/invoice")
public class InvoiceController
{

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    InvoiceServiceImpl invoiceService;

    private Invoices invoices;

    private Customer customer;

    private Customer cust2;

    @CrossOrigin
    @PostMapping(path="/{customerId}/addInvoice")
    public @ResponseBody
    Invoices create(@PathVariable long customerId)
    {

        Optional<Customer> customer = customerService.read(customerId);

        if (customer.isPresent())
        {
            cust2 = customer.get();
        }

        invoices = InvoiceFactory.getInvoice(cust2);

        return  invoiceService.create(invoices);
    }
    @CrossOrigin
    @GetMapping (path="/{customerId}/findInvoice")
    public @ResponseBody
    ResponseEntity findByCustomer (@PathVariable long customerId, @RequestParam long id)
    {

        Optional <Invoices> invoice = invoiceService.read(id);

        if(!invoice.isPresent())
        {
            return new ResponseEntity("No invoice found for customer" + customerId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(invoice, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping (path="/{customerId}/updateInvoice")
    public @ResponseBody
    Invoices updateOrder (@PathVariable long customerId, @RequestParam long id) {

        Optional<Customer> cust = customerService.read(customerId);

        if (cust.isPresent())
        {
            cust2 = cust.get();
        }
        Invoices invoiceUpdate = new Invoices.Builder()
                .id(id)
                .customer(customer)
                .build();

        return invoiceService.update(invoiceUpdate);
    }
    @CrossOrigin
    @GetMapping (path="/deleteInvoice")
    public @ResponseBody void updateOrder (@RequestParam Invoices id) {
        invoiceService.delete(id);

    }
}
