package com.example.procesos.infrastructure.web;

import java.time.LocalDateTime;
import java.util.Map;

public record ProcessStatisticsDTO(
        long totalProcesses,
        long activeProcesses,
        Map<String, Long> processesByName,
        LocalDateTime earliestProcessDate,
        LocalDateTime latestProcessDate
) {}