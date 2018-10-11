package com.Group3.controllers;

import com.Group3.domain.Car;
import com.Group3.domain.Category;
import com.Group3.factories.CarFactory;
import com.Group3.services.Impl.CarServiceImpl;
import com.Group3.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/car")
public class CarController {

    private Car car;
    private Category category;
    private Category cat;
    private Category cat2;

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @CrossOrigin
    @PostMapping(path = "/addCar")
    public @ResponseBody
    ResponseEntity create(@RequestBody Car car)
    {

        if(StringUtils.isEmpty(car.getCategoryId()) || StringUtils.isEmpty(car.getMake()) || StringUtils.isEmpty(car.getModel()) || StringUtils.isEmpty(car.getYear()) ||
                StringUtils.isEmpty(car.getNumberPlate()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }

        carService.create(car);
        return new ResponseEntity(car, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(path = "/readCar/{id}")
    public @ResponseBody ResponseEntity findByCustomerId(@PathVariable("id") int customerId)
    {

        Car car = carService.findByCustomerId(customerId);
        System.out.println(customerId);
        if(car.getCustomerId() == 0)
        {
            return new ResponseEntity("No car found for customer" + customerId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(car, HttpStatus.OK);
    }

    @CrossOrigin
    //function to edit the car according to the transaction
    @RequestMapping (value = "/updateCar", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Car car)
    {

        carService.update(car);

        return new ResponseEntity(car, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/deleteCar")
    public @ResponseBody void delete(@RequestParam Car id)
    {
        carService.delete(id);
    }

    @CrossOrigin
    //function to read all cars in the database and print to table
    @GetMapping(path = "/readAllCars")
    public @ResponseBody Iterable<Car> getAllCar()
    {
        return carService.readAll();
    }

}
