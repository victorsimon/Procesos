package com.example.procesos.infrastructure.data;

import com.example.procesos.domain.Process;
import com.example.procesos.domain.port.out.ProcessRepository;
import com.example.procesos.infrastructure.data.jpa.entity.ProcessEntity;
import com.example.procesos.infrastructure.data.jpa.entity.ProcessJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class ProcessSQLRepository implements ProcessRepository {

    private final ProcessJpaRepository processJpaRepository;

    @Override
    public Process save(Process process) {
        return ProcessMapper.toDomain(
                processJpaRepository.save(
                    ProcessMapper.toEntity(process))
        );
    }

    @Override
    public List<Process> findAll() {
        List<ProcessEntity> processes = processJpaRepository.findAll();
        return processes.stream()
                .map(ProcessMapper::toDomain)
                .toList();
    }
}
