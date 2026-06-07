package com.example.aidevsec.admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdminController {

    @GetMapping("/api/v1/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, String> dashboard() {

        return Map.of(
                "message",
                "Welcome Admin"
        );
    }
}