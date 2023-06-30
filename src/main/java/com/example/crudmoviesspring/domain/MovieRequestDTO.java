package com.example.crudmoviesspring.domain;

import lombok.NonNull;

public record MovieRequestDTO(
        String id,
        @NonNull
        String name,
        @NonNull
        String director,
        @NonNull
        Integer releaseYear,
        boolean available,
        @NonNull
        Integer price) {
}
