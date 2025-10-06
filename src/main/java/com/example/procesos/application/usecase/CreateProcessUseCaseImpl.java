package com.example.procesos.application.usecase;

import com.example.procesos.domain.port.in.CreateProcessUseCase;
import com.example.procesos.domain.Process;
import com.example.procesos.domain.port.out.ProcessRepository;
import com.example.procesos.domain.validation.ProcessValidator;
import com.example.procesos.domain.validation.exception.InvalidProcessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CreateProcessUseCaseImpl implements CreateProcessUseCase {

    private final ProcessRepository processRepository;
    private final ProcessValidator processValidator;

    @Override
    public Process create(String processId, String name, LocalDateTime initDateTime, LocalDateTime endDateTime) throws InvalidProcessException {
        Process process = new Process(processId, name, initDateTime, endDateTime);
        processRepository.save(processValidator.validate(process));
        return process;
    }
}
