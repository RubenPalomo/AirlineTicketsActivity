package com.airline.AirlineUser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.AirlineUser.models.HttpResponse;
import com.airline.AirlineUser.models.User;
import com.airline.AirlineUser.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findbyId(@PathVariable String id) {
        return userService.findById(id).get();
    }

    @PostMapping()
    public HttpResponse save(@RequestBody User user) {
        try {
            findbyId(user.getDocument());
            return new HttpResponse("", "User already exists", false);
        } catch (Exception e) {
            // TODO: handle exception
            userService.save(user);
            return new HttpResponse("", "User correclty created", true);
        }

    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }
}
