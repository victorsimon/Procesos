package com.example.procesos.application.usecase;

import com.example.procesos.domain.Process;
import com.example.procesos.domain.port.in.GetProcessStatisticsUseCase;
import com.example.procesos.domain.port.out.ProcessRepository;
import com.example.procesos.infrastructure.web.ProcessStatisticsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetProcessStatisticsUseCaseImpl implements GetProcessStatisticsUseCase {

    private final ProcessRepository processRepository;

    @Override
    public ProcessStatisticsDTO calculate(LocalDateTime initDateTime, LocalDateTime endDateTime) {
        List<Process> allProcesses = processRepository.findAll();

        long activeProcesses = allProcesses.stream()
                .filter(process -> isProcessActive(process, initDateTime, endDateTime))
                .count();

        Map<String, Long> processesByName = allProcesses.stream()
                .collect(Collectors.groupingBy(
                        Process::getName,
                        Collectors.counting()
                ));

        LocalDateTime earliestDate = allProcesses.stream()
                .map(Process::getInitDateTime)
                .min(LocalDateTime::compareTo)
                .orElse(initDateTime);

        LocalDateTime latestDate = allProcesses.stream()
                .map(Process::getEndDateTime)
                .max(LocalDateTime::compareTo)
                .orElse(endDateTime);

        return new ProcessStatisticsDTO(
                allProcesses.size(),
                activeProcesses,
                processesByName,
                earliestDate,
                latestDate
        );
    }

    private boolean isProcessActive(Process process, LocalDateTime startDate, LocalDateTime endDate) {
        LocalDateTime processStart = process.getInitDateTime();
        LocalDateTime processEnd = process.getEndDateTime();

        return !processStart.isAfter(endDate) && !processEnd.isBefore(startDate);
    }
}
