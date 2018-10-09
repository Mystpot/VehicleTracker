package com.Group3.controllers;

import com.Group3.domain.User;
import com.Group3.factories.UserFactory;
import com.Group3.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController
{
    private User user;

    @Autowired
    private UserServiceImpl userService;

    @CrossOrigin
    @PostMapping(path="/addUser")
    public @ResponseBody
    User addUser(@RequestParam String name, @RequestParam String surname, @RequestParam String password, @RequestParam String role)
    {
        user = UserFactory.getUser(name,surname,password,role);
        return  userService.create(user);
    }

    @CrossOrigin
    @GetMapping (path="/findByUserID")
    public @ResponseBody
    ResponseEntity findByUserID(@RequestParam long userID)
    {
        {
            Optional<User> user = userService.read(userID);

            if(!user.isPresent())
            {
                return new ResponseEntity("No user found for user" + userID, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(user, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @GetMapping (path = "/findAllUsers")
    public @ResponseBody Iterable<User> findAllUsers()
    {
        return userService.findAllUsers();
    }


    @CrossOrigin
    @GetMapping(path="/updateUser")
    public @ResponseBody
    User updateUser(@RequestParam long userID,@RequestParam String name, @RequestParam String surname,@RequestParam String password,@RequestParam String role)
    {

        User userUpdate=UserFactory.getUserByID(userID,name,surname,password,role);

        return  userService.update(userUpdate);
    }

    @CrossOrigin
    @GetMapping (path = "/deleteUser")
    public @ResponseBody void delete(@RequestParam User userID)
    {
        userService.delete(userID);
    }

    @CrossOrigin
    @GetMapping (path = "/findByName")
    public @ResponseBody User findEmail(@RequestParam String email)
    {
        return userService.findByName(email);
    }


}
