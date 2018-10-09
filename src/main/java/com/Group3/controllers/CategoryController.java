package com.Group3.controllers;

import com.Group3.domain.Category;
import com.Group3.factories.CategoryFactory;
import com.Group3.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    private Category category;
    private Category cat;

    @Autowired
    private CategoryServiceImpl categoryService;

    @CrossOrigin
    @PostMapping(path="/addCategory")
    public @ResponseBody
    ResponseEntity create(@RequestParam String name, @RequestParam double price)
    {
        category = CategoryFactory.getCategory(name, price);
        if(StringUtils.isEmpty(category.getName()) || StringUtils.isEmpty(category.getPrice()))
        {
            return new ResponseEntity("Need extra information", HttpStatus.NO_CONTENT);
        }

        categoryService.create(category);
        return new ResponseEntity(category, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping (path="/findByName")
    public @ResponseBody Category findByName(@RequestParam String name)
    {
        return categoryService.findByName(name);
    }

    @CrossOrigin
    @GetMapping (path="/read")
    public @ResponseBody ResponseEntity read(@RequestParam long id)
    {
        Optional<Category> cat = categoryService.read(id);

        if(!cat.isPresent())
        {
            return new ResponseEntity("No car found for car" + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(cat, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping (path = "/readAll")
    public @ResponseBody Iterable<Category> getCategory()
    {
        return categoryService.readAll();
    }
}
