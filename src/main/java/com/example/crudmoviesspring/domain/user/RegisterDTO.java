package com.example.crudmoviesspring.domain.user;

public record RegisterDTO(
        String login,
        String password,
        UserRole role) {
}
