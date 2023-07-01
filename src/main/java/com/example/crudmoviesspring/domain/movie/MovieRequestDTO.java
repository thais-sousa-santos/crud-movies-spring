package com.example.crudmoviesspring.domain.movie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovieRequestDTO(
        @NotNull
        String id,
        @NotBlank
        String name,
        @NotBlank
        String director,
        @NotNull
        Integer releaseYear,
        boolean available,
        @NotNull
        Integer price) {
}
