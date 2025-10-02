package com.example.procesos.domain.port.in;

import com.example.procesos.infrastructure.web.ProcessStatisticsDTO;

import java.time.LocalDateTime;

public interface GetProcessStatisticsUseCase {
    ProcessStatisticsDTO calculate(LocalDateTime init, LocalDateTime end);
}
