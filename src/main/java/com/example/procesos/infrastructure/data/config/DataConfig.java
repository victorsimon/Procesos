package com.example.procesos.infrastructure.data.config;

import com.example.procesos.application.util.validator.ProcessAllwaysTrueValidator;
import com.example.procesos.domain.port.out.ProcessRepository;
import com.example.procesos.domain.validator.ProcessValidator;
import com.example.procesos.infrastructure.data.ProcessSQLRepository;
import com.example.procesos.infrastructure.data.jpa.entity.ProcessJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    @Bean
    public ProcessRepository processRepository(ProcessJpaRepository processJpaRepository) {
        return new ProcessSQLRepository(processJpaRepository);
    }

    @Bean
    public ProcessValidator processValidator() {
        return new ProcessAllwaysTrueValidator();
    }
}
