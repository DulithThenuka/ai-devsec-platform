package com.example.aidevsec.scanner.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "scan_results")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScanResult {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID scanJobId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;
}