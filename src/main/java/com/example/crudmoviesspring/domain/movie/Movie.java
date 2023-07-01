package com.example.crudmoviesspring.domain.movie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Table(name = "movie")
@Entity(name = "movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String director;

    private Integer releaseYear;

    private boolean available;

    private Integer price;
    public Movie(MovieRequestDTO movieRequestDTO){
        this.id = movieRequestDTO.id();
        this.name = movieRequestDTO.name();
        this.director = movieRequestDTO.director();
        this.releaseYear = movieRequestDTO.releaseYear();
        this.available = movieRequestDTO.available();
        this.price = movieRequestDTO.price();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return available == movie.available && Objects.equals(id, movie.id)
                && Objects.equals(name, movie.name)
                && Objects.equals(director, movie.director)
                && Objects.equals(releaseYear, movie.releaseYear)
                && Objects.equals(price, movie.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, director, releaseYear, available, price);
    }
}
