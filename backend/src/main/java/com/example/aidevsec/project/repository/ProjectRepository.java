package com.example.aidevsec.project.repository;

import com.example.aidevsec.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository
        extends JpaRepository<Project, UUID> {
}