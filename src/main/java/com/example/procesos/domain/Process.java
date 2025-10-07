package com.example.procesos.domain;

import java.time.LocalDateTime;

public record Process(
        String processId,
        String name,
        LocalDateTime initDateTime,
        LocalDateTime endDateTime
) {}
