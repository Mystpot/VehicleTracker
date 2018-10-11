package com.Group3.controllers;

import com.Group3.domain.History;
import com.Group3.domain.Invoices;
import com.Group3.domain.Rent;
import com.Group3.factories.HistoryFactory;
import com.Group3.services.Impl.HistoryServiceImpl;
import com.Group3.services.Impl.InvoiceServiceImpl;
import com.Group3.services.Impl.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/history")
public class HistoryController
{
    private History history;
    private Invoices invoices;
    private Rent rent;
    private Invoices inv;
    private Rent re;
    private Invoices inv2;
    private Rent re2;

    @Autowired
    private HistoryServiceImpl historyService;

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @Autowired
    private RentServiceImpl rentService;

    @CrossOrigin
    @PostMapping(path="/{invoiceId}/{rentId}/addHistory")
    public @ResponseBody
    History createHistory(@PathVariable long invoiceId, @PathVariable int rentId, boolean rented, boolean outstanding)
    {
        Map<String, Boolean> values = new HashMap<>();
        values.put("rented",rented);
        values.put("outstanding",outstanding);

      Optional<Invoices> invoices = invoiceService.read(invoiceId);
      Optional<Rent> rent = rentService.readById(rentId);

      if (invoices.isPresent())
      {
          inv = invoices.get();
      }

      if (rent.isPresent())
      {
          re = rent.get();
      }

        history = HistoryFactory.getHistory(values,re, inv );

        return historyService.create(history);
    }

    @CrossOrigin
    @GetMapping (path="/findHistoryItem")
    public @ResponseBody
    ResponseEntity findHistoryItem(long historyId)
    {
        Optional<History> hist = historyService.read(historyId);

        if(!hist.isPresent())
        {
            return new ResponseEntity("No history found for customer" + historyId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(hist, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/{invoiceId}/{rentId}/updateHistory")
    public
    @ResponseBody History updateHistory(@PathVariable long invoiceId,@PathVariable int rentId,@RequestParam long id, boolean rented, boolean outstanding)
    {
        Optional<Invoices> invoices = invoiceService.read(invoiceId);
        Optional<Rent> rent = rentService.readById(rentId);

        if (invoices.isPresent())
        {
            inv2 = invoices.get();
        }

        if (rent.isPresent())
        {
            re2 = rent.get();
        }

        History historyUpdate = new History.Builder()
                .id(id)
                .invoices(inv2)
                .rent(re2)
                .rented(rented)
                .outstanding(outstanding)
                .build();
        return historyService.update(historyUpdate);
    }

    @CrossOrigin
    @DeleteMapping(path = "/deleteHistory")
    public
    @ResponseBody
    void deleteHistory(History historyID) {
        historyService.delete(historyID);
    }

    @CrossOrigin
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<History> getAllRentals()
    {
        return historyService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/{invoiceId}/findAllRentalBasedInvoice")
    public @ResponseBody ResponseEntity getAllBasedOnInvoice(@PathVariable long invoiceId)
    {
        Optional<History> hist = historyService.read(invoiceId);

        if(!hist.isPresent())
        {
            return new ResponseEntity("No history found for customer" + invoiceId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(hist, HttpStatus.OK);
    }
}
