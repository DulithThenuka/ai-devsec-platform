package com.example.aidevsec.scanner.repository;

import com.example.aidevsec.scanner.entity.ScanJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScanJobRepository
        extends JpaRepository<ScanJob, UUID> {

    List<ScanJob> findByProjectId(UUID projectId);
}