package com.MovieApp.TicketCounter.controller;

import com.MovieApp.TicketCounter.dto.request.MovieRequestDTO;
import com.MovieApp.TicketCounter.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<Object> addMovie(@RequestBody MovieRequestDTO payload){
        return new ResponseEntity<>(movieService.addMovie(payload), HttpStatus.CREATED);
    }

    @GetMapping("/get-movie/{id}")
    public ResponseEntity<Object> getMovieById(@PathVariable("id") int id){
        return new ResponseEntity<>(movieService.getMovieById(id),HttpStatus.OK);
    }

    @GetMapping("/get-all-movie")
    public ResponseEntity<Object> getAllMovie(){
        return new ResponseEntity<>(movieService.getAllMovie(),HttpStatus.OK);
    }

}
