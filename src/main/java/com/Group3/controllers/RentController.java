package com.Group3.controllers;

import com.Group3.domain.Car;
import com.Group3.domain.Customer;
import com.Group3.domain.Orders;
import com.Group3.domain.Rent;
import com.Group3.factories.RentFactory;
import com.Group3.services.Impl.CarServiceImpl;
import com.Group3.services.Impl.CustomerServiceImpl;
import com.Group3.services.Impl.OrderServiceImpl;
import com.Group3.services.Impl.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping(path = "/rent")
public class RentController
{
    private Rent rent;

    @Autowired
    private RentServiceImpl rentService;

    @CrossOrigin
    @PostMapping(path="/rentCar")
    public @ResponseBody
    Rent create(@RequestBody Rent rent)
    {

        return rentService.create(rent);

    }

    @CrossOrigin
    @GetMapping (path="/findRentedItem/{id}")
    public @ResponseBody ResponseEntity findByCustomer (@PathVariable("id") int customerId)
    {
        Rent rent = rentService.findCustomerId(customerId);
        System.out.println(customerId);
        if(rent.getCustomerId() == 0)
        {
            return new ResponseEntity("No rent found for customer" + customerId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(rent, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping (value = "/updateRent", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Rent rent)
    {

        rentService.update(rent);

        return new ResponseEntity(rent, HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping (path="/deleteRent")
    public @ResponseBody void updateRent (@RequestParam Rent id) {
        rentService.delete(id);

    }

    @CrossOrigin
    @GetMapping(path ="/findAllRentedCars")
    public @ResponseBody Iterable<Rent> getAllRentedCars()
    {
        return rentService.readAll();
    }

    @CrossOrigin
    @GetMapping(path="/findAllByCustomer/{customerId}")
    public @ResponseBody Iterable<Rent> findAllByCustomerId(@PathVariable("customerId") int customerId)
    {
        return rentService.findAllByCustomerId(customerId);
    }



}
