package com.example.aidevsec.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "projects")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String repositoryUrl;

    @Column(nullable = false)
    private String ownerEmail;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    private LocalDateTime createdAt;
}