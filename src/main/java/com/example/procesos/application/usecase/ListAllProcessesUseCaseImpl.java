package com.example.procesos.application.usecase;

import com.example.procesos.domain.Process;
import com.example.procesos.domain.port.in.ListAllProcessesUseCase;
import com.example.procesos.domain.port.out.ProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListAllProcessesUseCaseImpl implements ListAllProcessesUseCase {

    private final ProcessRepository processRepository;

    @Override
    public List<Process> list() {
        return processRepository.findAll();
    }
}
