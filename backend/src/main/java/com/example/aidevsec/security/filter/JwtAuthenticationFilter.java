package com.example.aidevsec.security.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter {
    @Component
    @RequiredArgsConstructor
    public class JwtAuthenticationFilter
            extends OncePerRequestFilter {
    }
}
