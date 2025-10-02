package com.example.procesos.domain.port.in;

import java.time.LocalDateTime;
import com.example.procesos.domain.Process;

public interface CreateProcessUseCase {
    Process create(String processId, String name, LocalDateTime initDateTime, LocalDateTime endDateTime);
}
