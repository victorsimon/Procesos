package com.example.procesos.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Process {
    private final String processId;
    private final String name;
    private final LocalDateTime initDateTime;
    private final LocalDateTime endDateTime;
}
