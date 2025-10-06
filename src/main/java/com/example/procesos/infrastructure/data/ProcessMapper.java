package com.example.procesos.infrastructure.data;

import com.example.procesos.infrastructure.data.jpa.entity.ProcessEntity;
import com.example.procesos.domain.Process;

public class ProcessMapper {

    public static Process toDomain(ProcessEntity processEntity) {
        return new Process(
                processEntity.getProcessId(),
                processEntity.getName(),
                processEntity.getInitDateTime(),
                processEntity.getEndDateTime()
        );
    }

    public static ProcessEntity toEntity(Process process) {
        ProcessEntity processEntity = new ProcessEntity();
        processEntity.setProcessId(process.processId());
        processEntity.setName(process.name());
        processEntity.setInitDateTime(process.initDateTime());
        processEntity.setEndDateTime(process.endDateTime());
        return processEntity;
    }
}
