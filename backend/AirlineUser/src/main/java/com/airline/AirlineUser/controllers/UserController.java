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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.airline.AirlineUser.models.HttpResponse;
import com.airline.AirlineUser.models.User;
import com.airline.AirlineUser.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public HttpResponse getUsers() {
        try {
            return new HttpResponse(userService.findAll().toString(), "Users found", true);
        } catch (Exception e) {
            return new HttpResponse("", "No user exist", false);
        }
    }

    @GetMapping("/{id}")
    public HttpResponse findbyId(@PathVariable String id) {
        try {
            return new HttpResponse(userService.findById(id).get().toString(), "User found", true);
        } catch (Exception e) {
            return new HttpResponse("", "User doesn't exist", false);
        }
    }

    @PostMapping()
    public HttpResponse save(@RequestBody User user) {
        try {
            findbyId(user.getDocument());
            return new HttpResponse("", "User already exists", false);
        } catch (Exception e) {
            userService.save(user);
            return new HttpResponse("", "User correctly created", true);
        }

    }

    @PutMapping("/{id}")
    public HttpResponse update(@PathVariable String id, @RequestBody User user) {
        try {
            findbyId(id);
            userService.save(user);
            return new HttpResponse("", "User correctly updated", true);
        } catch (Exception e) {
            return new HttpResponse("", "User doesn't exists", false);
        }
    }

    @DeleteMapping("/{id}")
    public HttpResponse deleteById(@PathVariable String id) {
        try {
            findbyId(id);
            userService.deleteById(id);
            return new HttpResponse("", "User correctly deleted", true);
        } catch (Exception e) {
            return new HttpResponse("", "User doesn't exists", false);
        }
    }
}
