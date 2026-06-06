package com.example.aidevsec.auth.controller;

import com.example.aidevsec.auth.dto.AuthResponse;
import com.example.aidevsec.auth.dto.LoginRequest;
import com.example.aidevsec.auth.dto.RegisterRequest;
import com.example.aidevsec.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(
            @Valid @RequestBody RegisterRequest request
    ) {

        authService.register(request);

        return new AuthResponse(
                "User registered successfully"
        );
    }
    @PostMapping("/login")
    public AuthResponse login(
            @Valid @RequestBody LoginRequest request
    ) {

        String token = authService.login(request);

        return new AuthResponse(token);
    }
}