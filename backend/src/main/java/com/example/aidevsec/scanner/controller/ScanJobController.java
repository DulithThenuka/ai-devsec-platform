package com.example.aidevsec.scanner.controller;

import com.example.aidevsec.scanner.entity.ScanJob;
import com.example.aidevsec.scanner.repository.ScanJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/scans")
@RequiredArgsConstructor
public class ScanJobController {

    private final ScanJobRepository scanJobRepository;

    @GetMapping("/{scanId}")
    public ScanJob getStatus(
            @PathVariable UUID scanId
    ) {

        return scanJobRepository
                .findById(scanId)
                .orElseThrow();
    }
}