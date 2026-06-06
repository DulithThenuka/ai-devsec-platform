package com.example.aidevsec.auth.service;

import com.example.aidevsec.auth.dto.LoginRequest;
import com.example.aidevsec.auth.dto.RegisterRequest;
import com.example.aidevsec.security.jwt.JwtService;
import com.example.aidevsec.user.entity.Role;
import com.example.aidevsec.user.entity.User;
import com.example.aidevsec.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public void register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .id(UUID.randomUUID())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }
    public String login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.email())
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );

        boolean matches =
                passwordEncoder.matches(
                        request.password(),
                        user.getPassword()
                );

        if (!matches) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(
                user.getEmail()
        );
    }
}