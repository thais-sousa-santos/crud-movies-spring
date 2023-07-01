package com.example.crudmoviesspring.repositories;

import com.example.crudmoviesspring.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
