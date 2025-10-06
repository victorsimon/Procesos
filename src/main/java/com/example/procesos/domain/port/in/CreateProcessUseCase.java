package com.example.procesos.domain.port.in;

import java.time.LocalDateTime;
import com.example.procesos.domain.Process;
import com.example.procesos.domain.validation.exception.InvalidProcessException;

public interface CreateProcessUseCase {
    Process create(String processId, String name, LocalDateTime initDateTime, LocalDateTime endDateTime) throws InvalidProcessException;
}
