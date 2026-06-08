package com.example.aidevsec.scanner.service;

import com.example.aidevsec.project.entity.Project;
import com.example.aidevsec.project.repository.ProjectRepository;
import com.example.aidevsec.scanner.dto.ScanResponse;
import com.example.aidevsec.scanner.entity.ScanJob;
import com.example.aidevsec.scanner.entity.ScanStatus;
import com.example.aidevsec.scanner.repository.ScanJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScanService {

    private final ScanJobRepository scanJobRepository;
    private final ProjectRepository projectRepository;
    private final ScanExecutorService scanExecutorService;

    public ScanResponse startScan(
            UUID projectId,
            String userEmail
    ) {

        Project project = projectRepository
                .findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        if (!project.getOwnerEmail().equals(userEmail)) {
            throw new RuntimeException("Access denied");
        }

        ScanJob scanJob = ScanJob.builder()
                .id(UUID.randomUUID())
                .projectId(projectId)
                .status(ScanStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        scanJobRepository.save(scanJob);

        // Start asynchronous scan
        scanExecutorService.executeScan(scanJob.getId());

        return new ScanResponse(
                scanJob.getId(),
                scanJob.getStatus()
        );
    }
}