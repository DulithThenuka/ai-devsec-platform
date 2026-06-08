package com.example.aidevsec.scanner.controller;

import com.example.aidevsec.scanner.dto.ScanResponse;
import com.example.aidevsec.scanner.service.ScanService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ScanController {

    private final ScanService scanService;

    @PostMapping("/{projectId}/scan")
    public ScanResponse startScan(
            @PathVariable UUID projectId,
            Authentication authentication
    ) {

        return scanService.startScan(
                projectId,
                authentication.getName()
        );
    }
}