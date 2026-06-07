package com.example.aidevsec.project.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectRequest(

        @NotBlank
        String name,

        @NotBlank
        String repositoryUrl

) {}