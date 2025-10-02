package com.example.procesos.application.usecase;

import com.example.procesos.application.util.validator.ProcessAllwaysTrueValidator;
import com.example.procesos.domain.Process;
import com.example.procesos.domain.port.out.ProcessRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateProcessUseCaseImplTest {

    private final ProcessAllwaysTrueValidator processValidator = new ProcessAllwaysTrueValidator();
    private final ProcessRepository processRepository = new ProcessRepository() {
        @Override
        public Process save(Process process) {
            return process;
        }

        @Override
        public List<Process> findAll() {
            return List.of();
        }
    };

    @Test
    void createHappyCase() {
        // Given
        CreateProcessUseCaseImpl sut = new CreateProcessUseCaseImpl(processRepository, processValidator);
        LocalDateTime dateTime = LocalDateTime.now();

        // When
        Process result = sut.create("123", "test", dateTime, dateTime);

        // Then
        assertNotNull(result);
        assertEquals("123", result.getProcessId());
        assertEquals("test", result.getName());
        assertEquals(dateTime, result.getInitDateTime());
        assertEquals(dateTime, result.getInitDateTime());
    }
}