package com.MovieApp.TicketCounter.controller;

import com.MovieApp.TicketCounter.dto.request.CityRequestDTO;
import com.MovieApp.TicketCounter.service.CityService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/add-city")
    public ResponseEntity<Object> addCity(@RequestBody CityRequestDTO payload){
        return new ResponseEntity<>(cityService.addCity(payload), HttpStatus.CREATED);
    }

    @GetMapping("/get-city/{id}")
    public ResponseEntity<Object> getCityById(@PathVariable("id") int id){
        return new ResponseEntity<>(cityService.getCityById(id),HttpStatus.OK);
    }

    @GetMapping("/get-all-city")
    public ResponseEntity<Object> getAllCity(){
        return new ResponseEntity<>(cityService.getAllCity(),HttpStatus.OK);
    }
}
