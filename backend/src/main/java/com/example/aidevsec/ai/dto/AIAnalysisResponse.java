package com.example.aidevsec.ai.dto;

public record AIAnalysisResponse(
        String title,
        String severity,
        String analysis,
        String recommendation
) {
}