package com.example.aidevsec.project.service;

import com.example.aidevsec.project.dto.CreateProjectRequest;
import com.example.aidevsec.project.entity.Project;
import com.example.aidevsec.project.entity.ProjectStatus;
import com.example.aidevsec.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project create(
            CreateProjectRequest request,
            String ownerEmail
    ) {

        Project project = Project.builder()
                .id(UUID.randomUUID())
                .name(request.name())
                .repositoryUrl(request.repositoryUrl())
                .ownerEmail(ownerEmail)
                .status(ProjectStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .build();

        return projectRepository.save(project);
    }

    public List<Project> getMyProjects(
            String ownerEmail
    ) {

        return projectRepository
                .findByOwnerEmail(ownerEmail);
    }
}