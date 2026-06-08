package com.example.aidevsec.scanner.dto;

import com.example.aidevsec.scanner.entity.ScanStatus;

import java.util.UUID;

public record ScanResponse(
        UUID id,
        ScanStatus status
) {
}