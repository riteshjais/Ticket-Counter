package com.MovieApp.TicketCounter.controller;

import com.MovieApp.TicketCounter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/all-users")
    public ResponseEntity<Object> getAllUser(){
        return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
    }


}
