package com.example.procesos.application.usecase;

import com.example.procesos.domain.Process;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CreateProcessUseCaseImplTest {

    @Test
    void createHappyCase() {
        // Given
        CreateProcessUseCaseImpl sut = new CreateProcessUseCaseImpl();
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