package com.example.aidevsec.project.controller;

import com.example.aidevsec.project.dto.CreateProjectRequest;
import com.example.aidevsec.project.entity.Project;
import com.example.aidevsec.project.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public Project createProject(
            @Valid @RequestBody
            CreateProjectRequest request,

            Authentication authentication
    ) {

        return projectService.create(
                request,
                authentication.getName()
        );
    }

    @GetMapping
    public List<Project> getProjects(
            Authentication authentication
    ) {

        return projectService.getMyProjects(
                authentication.getName()
        );
    }
}