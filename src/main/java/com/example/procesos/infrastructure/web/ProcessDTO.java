package com.example.procesos.infrastructure.web;

import com.example.procesos.domain.Process;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProcessDTO(
        @NotBlank String processId,
        @NotBlank String name,
        @NotNull LocalDateTime initDateTime,
        @NotNull LocalDateTime endDateTime
) {
    public static ProcessDTO from(Process process) {
        return new ProcessDTO(
                process.getProcessId(),
                process.getName(),
                process.getInitDateTime(),
                process.getEndDateTime()
        );
    }
}
