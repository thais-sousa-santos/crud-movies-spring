package com.example.crudmoviesspring.controllers;

import com.example.crudmoviesspring.domain.movie.Movie;
import com.example.crudmoviesspring.domain.movie.MovieRequestDTO;
import com.example.crudmoviesspring.repositories.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository moviesRepository;

    @GetMapping
    public ResponseEntity getAllMovies(){
        var allMovies = moviesRepository.findAll();
        return ResponseEntity.ok(allMovies);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity getMovieById(@PathVariable @Valid String id){
        var idMovie = moviesRepository.findById(id);
        return ResponseEntity.ok(idMovie);
    }

    @PostMapping
    public ResponseEntity registerMovies(@RequestBody @Valid MovieRequestDTO data){
        Movie newMovie = new Movie(data);
        moviesRepository.save(newMovie);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateMovies(@RequestBody @Valid MovieRequestDTO data){
        Optional<Movie> optionalMovies = moviesRepository.findById(data.id());
        if(optionalMovies.isPresent()){
            Movie movie = optionalMovies.get();
            movie.setName(data.name());
            movie.setDirector(data.director());
            movie.setReleaseYear(data.releaseYear());
            movie.setAvailable(data.available());
            movie.setPrice(data.price());
            moviesRepository.save(movie);
            return ResponseEntity.ok(movie);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovies(@PathVariable @Valid String id){
       Optional<Movie> optionalMovie = moviesRepository.findById(id);

       if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setAvailable(false);
            return ResponseEntity.noContent().build();
       } else {
           throw new EntityNotFoundException();
       }

    }


}
