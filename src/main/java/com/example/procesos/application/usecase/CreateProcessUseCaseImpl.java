package com.example.procesos.application.usecase;

import com.example.procesos.domain.port.in.CreateProcessUseCase;
import com.example.procesos.domain.Process;
import com.example.procesos.domain.port.out.ProcessRepository;
import com.example.procesos.domain.validator.ProcessValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CreateProcessUseCaseImpl implements CreateProcessUseCase {

    private final ProcessRepository processRepository;
    private final ProcessValidator processValidator;

    @Override
    public Process create(String processId, String name, LocalDateTime initDateTime, LocalDateTime endDateTime) {
        Process process = new Process(processId, name, initDateTime, endDateTime);
        if (!processValidator.validate(process)) {
            throw new IllegalArgumentException("Invalid process data");
        }
        process = processRepository.save(process);
        return process;
    }
}
