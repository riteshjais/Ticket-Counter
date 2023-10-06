package com.MovieApp.TicketCounter.service;

import com.MovieApp.TicketCounter.dto.request.MovieRequestDTO;
import com.MovieApp.TicketCounter.dto.respond.MovieRespondDTO;
import com.MovieApp.TicketCounter.model.MovieEntity;
import com.MovieApp.TicketCounter.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public MovieEntity addMovie(MovieRequestDTO requestDTO){
        MovieEntity movie= MovieEntity.builder()
                .movieName(requestDTO.getMovieName())
                .movieDescription(requestDTO.getMovieDescription())
                .certificationType(requestDTO.getCertificationType())
                .movieLanguage(requestDTO.getMovieLanguage())
                .releaseDate(requestDTO.getReleaseDate())
                .build();
        return movieRepository.save(movie);
    }

    public MovieRespondDTO getMovieById(Integer id){
        Optional<MovieEntity> optionalMovie=movieRepository.findById(id);
        if(optionalMovie.isEmpty())
            throw new EntityNotFoundException("Movie By this Id Doesn't Exist");
        MovieEntity movie=optionalMovie.get();
        MovieRespondDTO movieRespondDTO= MovieRespondDTO.builder()
                .movieId(movie.getMovieId())
                .movieName(movie.getMovieName())
                .movieDescription(movie.getMovieDescription())
                .movieLanguage(movie.getMovieLanguage())
                .certificationType(movie.getCertificationType())
                .releaseDate(movie.getReleaseDate())
                .build();
        return movieRespondDTO;
    }

    public List<MovieRespondDTO> getAllMovie(){
        List<MovieEntity> movieEntityList=movieRepository.findAll();
        List<MovieRespondDTO> movieRespondDTOList=new ArrayList<>();
        for(MovieEntity element: movieEntityList){
            MovieRespondDTO movieRespondDTO= MovieRespondDTO.builder()
                    .movieName(element.getMovieName())
                    .movieLanguage(element.getMovieLanguage())
                    .movieId(element.getMovieId())
                    .movieDescription(element.getMovieDescription())
                    .releaseDate(element.getReleaseDate())
                    .certificationType(element.getCertificationType())
                    .build();
            movieRespondDTOList.add(movieRespondDTO);
        }
        return movieRespondDTOList;
    }
}
