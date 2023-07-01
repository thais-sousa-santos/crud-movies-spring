package com.example.crudmoviesspring.controllers;

import com.example.crudmoviesspring.domain.user.AuthenticationDTO;
import com.example.crudmoviesspring.domain.user.LoginResponseDTO;
import com.example.crudmoviesspring.domain.user.RegisterDTO;
import com.example.crudmoviesspring.domain.user.User;
import com.example.crudmoviesspring.infra.security.TokenService;
import com.example.crudmoviesspring.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByLogin(data.login()) != null){
        return ResponseEntity.badRequest().build();
        }

        String encriptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encriptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
