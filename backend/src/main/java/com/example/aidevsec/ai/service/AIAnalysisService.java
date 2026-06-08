package com.example.aidevsec.ai.service;

import com.example.aidevsec.ai.dto.AIAnalysisResponse;
import com.example.aidevsec.scanner.entity.ScanResult;
import org.springframework.stereotype.Service;

@Service
public class AIAnalysisService {

    public AIAnalysisResponse analyze(
            ScanResult result
    ) {

        String analysis;
        String recommendation;

        switch (result.getSeverity()) {

            case CRITICAL -> {
                analysis =
                        "This vulnerability may lead to system compromise.";

                recommendation =
                        "Patch immediately and rotate any affected credentials.";
            }

            case HIGH -> {
                analysis =
                        "This issue represents a significant security risk.";

                recommendation =
                        "Apply security fixes in the next deployment cycle.";
            }

            case MEDIUM -> {
                analysis =
                        "Moderate security impact.";

                recommendation =
                        "Review and remediate when possible.";
            }

            default -> {
                analysis =
                        "Low risk finding.";

                recommendation =
                        "Monitor and address during maintenance.";
            }
        }

        return new AIAnalysisResponse(
                result.getTitle(),
                result.getSeverity().name(),
                analysis,
                recommendation
        );
    }
}