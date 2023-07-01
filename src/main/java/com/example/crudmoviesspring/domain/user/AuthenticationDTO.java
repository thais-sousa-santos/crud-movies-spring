package com.example.crudmoviesspring.domain.user;

public record AuthenticationDTO(
        String login,
        String password
) {
}
