package com.example.Pogoda.controller;

import com.example.Pogoda.exceptions.UserExistsException;
import com.example.Pogoda.model.User;
import com.example.Pogoda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            service.registerNewUser(user);
        } catch (UserExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registration successful",HttpStatus.CREATED);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
