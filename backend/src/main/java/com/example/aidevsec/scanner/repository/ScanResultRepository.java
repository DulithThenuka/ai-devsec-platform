package com.example.aidevsec.scanner.repository;

import com.example.aidevsec.scanner.entity.ScanResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScanResultRepository
        extends JpaRepository<ScanResult, UUID> {

    List<ScanResult> findByScanJobId(
            UUID scanJobId
    );
}