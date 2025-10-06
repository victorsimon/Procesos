package com.example.procesos.application.util.validator;

import com.example.procesos.domain.validation.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.procesos.domain.Process;

import java.time.LocalDateTime;

class ProcessSimpleValidatorImplTest {

    private final ProcessSimpleValidatorImpl sut = new ProcessSimpleValidatorImpl();

    @Test
    void validateHappyPath() throws InvalidProcessException {
        // Given
        Process process = new Process(
                "123",
                "123",
                LocalDateTime.now(),
                LocalDateTime.now().plusWeeks(1)
        );

        // When
        Process validated = sut.validate(process);

        // Then
        assertNotNull(validated);
    }

    @Test
    void validateInvalidProcess() {
        // Given

        // When
        InvalidProcessException exception = assertThrows(
                InvalidProcessException.class,
                () -> sut.validate(null)
        );

        // Then
        assertNotNull(exception);
    }

    @Test
    void validateInvalidProcessId() {
        // Given

        // When
        InvalidProcessIdException exceptionOnNull = assertThrows(
                InvalidProcessIdException.class,
                () -> sut.validate(new Process(
                        null,
                        "123",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusWeeks(1)
                ))
        );
        InvalidProcessIdException exceptionOnBlank = assertThrows(
                InvalidProcessIdException.class,
                () -> sut.validate(new Process(
                        "",
                        "123",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusWeeks(1)
                ))
        );

        // Then
        assertNotNull(exceptionOnNull);
        assertNotNull(exceptionOnBlank);

    }

    @Test
    void validateInvalidProcessName() {
        // Given

        // When
        InvalidProcessNameException exceptionOnNull = assertThrows(
                InvalidProcessNameException.class,
                () -> sut.validate(new Process(
                        "123",
                        null,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusWeeks(1)
                ))
        );
        InvalidProcessNameException exceptionOnBlank = assertThrows(
                InvalidProcessNameException.class,
                () -> sut.validate(new Process(
                        "123",
                        "",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusWeeks(1)
                ))
        );

        // Then
        assertNotNull(exceptionOnNull);
        assertNotNull(exceptionOnBlank);

    }

    @Test
    void validateInvalidProcessInitDateName() {
        // Given

        // When
        InvalidProcessInitDateException exception = assertThrows(
                InvalidProcessInitDateException.class,
                () -> sut.validate(new Process(
                        "123",
                        "123",
                        null,
                        LocalDateTime.now()
                ))
        );

        // Then
        assertNotNull(exception);
    }

    @Test
    void validateInvalidProcessEndDateName() {
        // Given

        // When
        InvalidProcessEndDateException exception = assertThrows(
                InvalidProcessEndDateException.class,
                () -> sut.validate(new Process(
                        "123",
                        "123",
                        LocalDateTime.now(),
                        null
                ))
        );

        // Then
        assertNotNull(exception);
    }

    @Test
    void validateInvalidProcessDateRange() {
        // Given

        // When
        InvalidProcessInitDateAfterEndDateException exception = assertThrows(
                InvalidProcessInitDateAfterEndDateException.class,
                () -> sut.validate(new Process(
                        "123",
                        "123",
                        LocalDateTime.now().plusDays(1),
                        LocalDateTime.now()
                ))
        );

        // Then
        assertNotNull(exception);

    }
}