package com.MovieApp.TicketCounter.controller;

import com.MovieApp.TicketCounter.dto.request.TheatreRequestDTO;
import com.MovieApp.TicketCounter.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/add-theatre")
    public ResponseEntity<Object> addTheatre(@RequestBody TheatreRequestDTO payload){
        return new ResponseEntity<>(theatreService.addTheatre(payload), HttpStatus.CREATED);
    }

    @GetMapping("/get-theatre/{id}")
    public ResponseEntity<Object> getTheatreById(@PathVariable("id") int id){
        return new ResponseEntity<>(theatreService.getTheatreById(id),HttpStatus.OK);
    }

    @GetMapping("/get-theatre")
    public ResponseEntity<Object> getAllTheatre(){
        return new ResponseEntity<>(theatreService.getAllTheatre(),HttpStatus.OK);
    }
}
