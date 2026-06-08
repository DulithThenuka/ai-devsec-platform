package com.example.aidevsec.ai.controller;

import com.example.aidevsec.ai.dto.AIAnalysisResponse;
import com.example.aidevsec.ai.service.AIAnalysisService;
import com.example.aidevsec.scanner.entity.ScanResult;
import com.example.aidevsec.scanner.repository.ScanResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AIAnalysisController {

    private final ScanResultRepository scanResultRepository;
    private final AIAnalysisService aiAnalysisService;

    @GetMapping("/analysis/{resultId}")
    public AIAnalysisResponse analyze(
            @PathVariable UUID resultId
    ) {

        ScanResult result =
                scanResultRepository
                        .findById(resultId)
                        .orElseThrow();

        return aiAnalysisService.analyze(result);
    }
}