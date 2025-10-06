package com.example.procesos.application.usecase;

import com.example.procesos.application.util.validator.ProcessSimpleValidatorImpl;
import com.example.procesos.domain.Process;
import com.example.procesos.domain.port.out.ProcessRepository;
import com.example.procesos.domain.validation.ProcessValidator;
import com.example.procesos.domain.validation.exception.InvalidProcessException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateProcessUseCaseImplTest {

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
    void createHappyCase() throws InvalidProcessException {
        // Given
        ProcessValidator processValidator = new ProcessSimpleValidatorImpl();
        CreateProcessUseCaseImpl sut = new CreateProcessUseCaseImpl(processRepository, processValidator);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime plusOneWeek = now.plusWeeks(1);

        // When
        Process result = sut.create("123", "test", now, plusOneWeek);

        // Then
        assertNotNull(result);
        assertEquals("123", result.processId());
        assertEquals("test", result.name());
        assertEquals(now, result.initDateTime());
        assertEquals(plusOneWeek, result.endDateTime());
    }

    @Test
    void createInvalidProcessException() {
        // Given
        ProcessValidator processValidator = new ProcessSimpleValidatorImpl();
        CreateProcessUseCaseImpl sut = new CreateProcessUseCaseImpl(processRepository, processValidator);

        // When
        InvalidProcessException exception = assertThrows(
                InvalidProcessException.class,
                () -> sut.create(null, null, null, null)
        );

        // Then
        assertNotNull(exception);
    }

}