package com.example.procesos.infrastructure.web;

import com.example.procesos.domain.port.in.CreateProcessUseCase;
import com.example.procesos.domain.Process;
import com.example.procesos.domain.port.in.ListAllProcessesUseCase;
import com.example.procesos.domain.port.in.GetProcessStatisticsUseCase;
import com.example.procesos.domain.validation.exception.InvalidProcessException;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

@RestController
@RequestMapping("process")
@RequiredArgsConstructor
public class ProcessController {

    private final CreateProcessUseCase createProcessUseCase;
    private final ListAllProcessesUseCase listAllProcessesUseCase;
    private final GetProcessStatisticsUseCase getProcessStatisticsUseCase;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ProcessDTO> save(@Valid @RequestBody ProcessDTO processDto) throws InvalidProcessException {
        if (processDto.endDateTime().isBefore(processDto.initDateTime())) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }

        Process process = createProcessUseCase.create(
                processDto.processId(),
                processDto.name(),
                processDto.initDateTime(),
                processDto.endDateTime()
        );

        return ResponseEntity.ok(ProcessDTO.from(process));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ProcessDTO>> findAll() {
        List<Process> processes = listAllProcessesUseCase.list();
        List<ProcessDTO> processDTOs = processes.stream()
                .map(ProcessDTO::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(processDTOs);
    }

    @GetMapping("/statistics")
    @ResponseBody
    public ResponseEntity<ProcessStatisticsDTO> getStatistics(
            @RequestParam("init") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime init,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        if (end.isBefore(init)) {
            throw new IllegalArgumentException("La fecha 'fin' no puede ser anterior a la fecha 'inicio'");
        }

        ProcessStatisticsDTO statistics = getProcessStatisticsUseCase.calculate(init, end);
        return ResponseEntity.ok(statistics);
    }
}
