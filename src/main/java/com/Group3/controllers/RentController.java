package com.Group3.controllers;

import com.Group3.domain.Car;
import com.Group3.domain.Orders;
import com.Group3.domain.Rent;
import com.Group3.factories.RentFactory;
import com.Group3.services.Impl.CarServiceImpl;
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
    private Car car;
    private Orders order;
    private Car car2;
    private Orders order2;

    @Autowired
    private RentServiceImpl rentService;

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private OrderServiceImpl orderService;

    @CrossOrigin
    @PostMapping(path="/{orderId}/{carId}/rentCar")
    public @ResponseBody
    Rent create(@PathVariable long orderId, @PathVariable long carId,
                @RequestParam String rentDate, @RequestParam String returnDate,
                @RequestParam BigDecimal totalPrice, @RequestParam int rentalDays, @RequestParam boolean outstanding)
    {

        Optional<Car> car = carService.read(carId);

        if (car.isPresent())
        {
            car2 = car.get();
        }

        Optional<Orders> order = orderService.read(orderId);

        if (order.isPresent()) {
            order2 = order.get();
        }

        rent = RentFactory.getRent(car2, rentDate,returnDate,totalPrice,order2, rentalDays, outstanding);
        return rentService.create(rent);

    }

    @CrossOrigin
    @GetMapping (path="/findRentedItem")
    public @ResponseBody ResponseEntity findByCustomer (@RequestParam Long id)
    {
        Optional <Rent> rent = rentService.read(id);

        if(!rent.isPresent())
        {
            return new ResponseEntity("No rent found for customer" + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(rent, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping (path="/{orderId}/{carId}/updateRent")
    public @ResponseBody Rent updateRent (@PathVariable long orderId, @PathVariable long carId,
                                          @RequestParam Long rentId,
                                          @RequestParam String rentDate, @RequestParam String returnDate,
                                          @RequestParam BigDecimal totalPrice, @RequestParam int rentalDays,
                                          @RequestParam boolean outstanding) {

        Optional<Car> car = carService.read(carId);

        if (car.isPresent())
        {
            car2 = car.get();
        }

        Optional<Orders> order = orderService.read(orderId);

        if (order.isPresent()) {
            order2 = order.get();
        }

        Rent rentUpdate = new Rent.Builder()
                .id(rentId)
                .rentDate(rentDate)
                .returntDate(returnDate)
                .rentalDays(rentalDays)
                .totalPrice(totalPrice)
                .outstanding(outstanding)
                .build();

        return rentService.update(rentUpdate);
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



}
