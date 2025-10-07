package com.example.procesos.application.util.validator;

import com.example.procesos.domain.validation.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.procesos.domain.Process;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

class ProcessSimpleValidatorImplTest {

    private final ProcessSimpleValidatorImpl sut = new ProcessSimpleValidatorImpl();

    @ParameterizedTest
    @MethodSource("validProcesses")
    void validateHappyPath(Process process) throws InvalidProcessException {
        // Given

        // When
        Process validated = sut.validate(process);

        // Then
        assertNotNull(validated);
    }

    private static Stream<Process> validProcesses() {
        return Stream.of(
                new Process("123", "123", LocalDateTime.now(), LocalDateTime.now().plusWeeks(1)),
                new Process("aaa", "bbb", LocalDateTime.now(), LocalDateTime.now().plusDays(1)),
                new Process("a123", "b123", LocalDateTime.now().minusDays(3), LocalDateTime.now().plusWeeks(1)),
                new Process("123", "123", LocalDateTime.now().minusDays(1), LocalDateTime.now().plusMinutes(2))
        );
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

    @ParameterizedTest
    @MethodSource("invalidProcessIds")
    void validateInvalidProcessId(Process process) {
        // Given

        // When
        InvalidProcessIdException exception = assertThrows(
                InvalidProcessIdException.class,
                () -> sut.validate(process)
        );

        // Then
        assertNotNull(exception);
    }
    private static Stream<Process> invalidProcessIds() {
        return Stream.of(
                new Process(null, "123", LocalDateTime.now(), LocalDateTime.now().plusWeeks(1)),
                new Process("", "bbb", LocalDateTime.now(), LocalDateTime.now().plusDays(1))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidProcessNames")
    void validateInvalidProcessName(Process process) {
        // Given

        // When
        InvalidProcessNameException exception = assertThrows(
                InvalidProcessNameException.class,
                () -> sut.validate(process)
        );

        // Then
        assertNotNull(exception);
    }
    private static Stream<Process> invalidProcessNames() {
        return Stream.of(
                new Process("123", null, LocalDateTime.now(), LocalDateTime.now().plusWeeks(1)),
                new Process("123", "", LocalDateTime.now(), LocalDateTime.now().plusDays(1))
        );
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