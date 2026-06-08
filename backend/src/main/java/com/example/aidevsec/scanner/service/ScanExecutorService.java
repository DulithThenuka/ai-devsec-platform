package com.example.aidevsec.scanner.service;

import com.example.aidevsec.scanner.entity.*;
import com.example.aidevsec.scanner.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScanExecutorService {

    private final ScanJobRepository scanJobRepository;
    private final ScanResultRepository scanResultRepository;

    @Async
    public void executeScan(
            UUID scanJobId
    ) {

        try {

            ScanJob scanJob =
                    scanJobRepository
                            .findById(scanJobId)
                            .orElseThrow();

            scanJob.setStatus(
                    ScanStatus.RUNNING
            );

            scanJobRepository.save(scanJob);

            Thread.sleep(5000);

            scanResultRepository.save(
                    ScanResult.builder()
                            .id(UUID.randomUUID())
                            .scanJobId(scanJobId)
                            .title(
                                    "Hardcoded Secret"
                            )
                            .description(
                                    "Potential API key detected"
                            )
                            .severity(
                                    Severity.CRITICAL
                            )
                            .build()
            );

            scanResultRepository.save(
                    ScanResult.builder()
                            .id(UUID.randomUUID())
                            .scanJobId(scanJobId)
                            .title(
                                    "Outdated Dependency"
                            )
                            .description(
                                    "Spring dependency vulnerable"
                            )
                            .severity(
                                    Severity.HIGH
                            )
                            .build()
            );

            scanJob.setStatus(
                    ScanStatus.COMPLETED
            );

            scanJobRepository.save(scanJob);

        } catch (Exception e) {

            ScanJob failedJob =
                    scanJobRepository
                            .findById(scanJobId)
                            .orElseThrow();

            failedJob.setStatus(
                    ScanStatus.FAILED
            );

            scanJobRepository.save(
                    failedJob
            );
        }
    }
}