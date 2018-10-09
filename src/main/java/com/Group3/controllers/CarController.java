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
    @PostMapping(path = "/{categoryId}/addCar")
    public @ResponseBody
    ResponseEntity create(@PathVariable long categoryId,
                          @RequestParam String make, @RequestParam String model,
                          @RequestParam int year, @RequestParam String numberPlate,
                          @RequestParam boolean status)
    {
        Map<String, String> stringValues = new HashMap<String, String>();
        stringValues.put("make", make);
        stringValues.put("model", model);
        stringValues.put("numberPlate", numberPlate);

        Optional<Category> category = categoryService.read(categoryId);

        if (category.isPresent())
        {
            cat = category.get();
        }
        car = CarFactory.getCar(cat, stringValues, year, status);

        if(StringUtils.isEmpty(car.getCategory()) || StringUtils.isEmpty(car.getMake()) || StringUtils.isEmpty(car.getModel()) || StringUtils.isEmpty(car.getYear()) ||
                StringUtils.isEmpty(car.getNumberPlate()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }

        carService.create(car);
        return new ResponseEntity(car, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(path = "/readCar")
    public @ResponseBody ResponseEntity read(@RequestParam long id)
    {
        Optional <Car> car = carService.read(id);

        if(!car.isPresent())
        {
            return new ResponseEntity("No car found for car" + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(car, HttpStatus.OK);
    }

    @CrossOrigin
    //function to edit the car according to the transaction
    @GetMapping (path = "/{categoryId}/updateCar")
    public @ResponseBody Car update(@PathVariable long categoryId, @RequestParam long id, @RequestParam String make, @RequestParam String model,
                                    @RequestParam int year, @RequestParam String numberPlate,
                                    @RequestParam boolean status)
    {

        //category = categoryService.read(categoryId);
        Optional<Category> category = categoryService.read(categoryId);

        if (category.isPresent())
        {
            cat2 = category.get();
        }

        Car carUpdate = new Car.Builder()
                .id(id)
                .make(make)
                .model(model)
                .year(year)
                .numberPlate(numberPlate)
                .status(status)
                .category(cat2)
                .build();

        return carService.update(carUpdate);
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
